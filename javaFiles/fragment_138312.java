ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
ses.scheduleAtFixedRate(new Runnable() {
    @Override
    public void run() {
        try(Connection conn = source.getConnection()){
            if(!conn.isValid(3600)){
                // do something if the connection is invalid
            }
        }
    }
}, 0, 1, TimeUnit.HOURS);