@Test
public void testCountUserOnline() throws Exception {

    List<HttpServletRequest> requests = new ArrayList<HttpServletRequest>();

    HttpServletRequest request1 = Mockito.mock(HttpServletRequest.class);
    HttpServletRequest request2 = Mockito.mock(HttpServletRequest.class);
    HttpServletRequest request3 = Mockito.mock(HttpServletRequest.class);

    Mockito.when(request1.getRemoteAddr()).thenReturn(String.format("192.168.1.%s", 1));
    Mockito.when(request2.getRemoteAddr()).thenReturn(String.format("192.168.1.%s", 2));
    Mockito.when(request3.getRemoteAddr()).thenReturn(String.format("192.168.1.%s", 3));

    requests.add(request1);
    requests.add(request2);
    requests.add(request3);

    List<Thread> threads = new ArrayList<Thread>();

    Thread thread1 = new Thread(new RequestRunnable(request1, 50, "1", "2"));
    Thread thread2 = new Thread(new RequestRunnable(request2, 20, "1", "3"));
    Thread thread3 = new Thread(new RequestRunnable(request3, 10, "3", "1"));

    threads.add(thread1);
    threads.add(thread2);
    threads.add(thread3);


    for (Thread thread : threads) {
        thread.start();
    }

    for (Thread thread : threads) {
        thread.join();
    }
}

class RequestRunnable implements Runnable {
    private HttpServletRequest request;
    private String [] pageSet;
    private int duration;


    public RequestRunnable(HttpServletRequest request, int duration, String ... pageSet) {
        this.request = request;
        this.pageSet = pageSet;
        this.duration = duration;
    }

    public void run() {
        try {
            int i = 0;
            while(i < duration) {
                i ++;
                for (String page : pageSet) {
                    eventService.countUserOnline(request, page);
                }

                LOG.debug("Second " + i);
                Thread.sleep(1000);
            }

        } catch (CAServiceException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}