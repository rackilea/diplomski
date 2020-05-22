//hotfix code bellow
private static final Timer timer = new Timer();
//hotfix code above
protected synchronized void stopSelectorRunners() {
    if (selectorRunners == null) {
        return;
    }

    for (int i = 0; i < selectorRunners.length; i++) {
        SelectorRunner runner = selectorRunners[i];
        if (runner != null) {
            runner.stop();
            //hotfix code below
            final Selector selector = runner.getSelector();
            if(selector !=null) {
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        try {
                            selector.close();
                        } catch (IOException e) {
                        }
                    }
                }, 100);
            }
            //hotfix code above
            selectorRunners[i] = null;
        }
    }

    selectorRunners = null;
}