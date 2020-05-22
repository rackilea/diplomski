// make it as static, since this needs to be singleton
private static Map<String, Map<String, Date>> numberOfCurrentViews;

// make it as static, since this needs to be singleton
private static Thread cleaningOffLineUserThread;

class OnlineCountingDownRunnable implements Runnable {

    @Override
    public void run() {
        try {
            while(true) {
                for (String itemId : numberOfCurrentViews.keySet()) {
                    Map<String, Date> userView = numberOfCurrentViews.get(itemId);

                    Iterator<Map.Entry<String, Date>> iterator = userView.entrySet().iterator();
                    while (iterator.hasNext()) {
                        Map.Entry<String, Date> views = iterator.next();

                        Date lastViewTime = views.getValue();
                        Date currentTime = new Date();
                        long seconds = (currentTime.getTime() - lastViewTime.getTime()) / 1000;

                        if (seconds > TIMEOUT) {
                            iterator.remove();
                        }
                    }
                }

                // make the cleaning worker running every 2 seconds
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            LOG.error("---------------- Thread error in counting down online user: " + e.getMessage());
        }

    }
}

public int countUserOnline(HttpServletRequest request, String itemId) throws CAServiceException {
    // create a count down timer to detect if the user does not view the page anymore
    String ip = request.getRemoteAddr();

    // init counting down online user map
    if (numberOfCurrentViews == null) {
        numberOfCurrentViews = new ConcurrentHashMap<String, Map<String, Date>>();
    }

    // start thread to check user online
    if (cleaningOffLineUserThread == null) {
        cleaningOffLineUserThread = new Thread(new OnlineCountingDownRunnable());
        cleaningOffLineUserThread.start();
    }

    LOG.debug("---------------- Requested IP: " + ip);
    if (ip == null || ip.isEmpty()) {
        throw new CAServiceException("======= Cannot detect Ip of the client =======");
    }

    Map<String, Date> userView;

    if (numberOfCurrentViews.get(itemId) != null) {
        userView = numberOfCurrentViews.get(itemId);
    } else {
        userView = new ConcurrentHashMap<String, Date>();
    }

    userView.put(ip, new Date());
    numberOfCurrentViews.put(itemId, userView);

    LOG.debug(String.format(
        "============= %s is seeing there is %s users, %s viewing item %s =============",
        ip, numberOfCurrentViews.get(itemId).size(),
        String.valueOf(numberOfCurrentViews.get(itemId).keySet()), itemId
    ));

    return numberOfCurrentViews.get(itemId).size();
}