private LogbackValve getLogbackValve() {
        LogbackValve valve = new LogbackValve();
        valve.setFilename(logbackAccessProperties.getConfig());
        valve.setAsyncSupported(true); // This line fixed the issue
        return valve;
    }