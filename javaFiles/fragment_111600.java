driver.getDevTools().createSession();
    driver.getDevTools().send(new Command("Profiler.enable", ImmutableMap.of()));
    driver.getDevTools().send(new Command("Profiler.start", ImmutableMap.of()));
    //register to profiler events
    driver.getDevTools().addListener(new Event("Profiler.consoleProfileStarted", ConsoleProfileStarted.class), new Consumer<Object>() {
        @Override
        public void accept(Object o) {
            //do something
        }
    });