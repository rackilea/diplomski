public void contextInitialized(final ServletContextEvent event) { 
        // start task
        executor = Executors.newSingleThreadExecutor();
        executor.submit(new Runnable() {
            @Override
            public void run() {
                String data = readFromPort();
                event.getServletContext().setAttribute("serialPortData", data); 
            }
        });
    }
}