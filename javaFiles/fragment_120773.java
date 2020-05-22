private void addSessionHandler(final Environment env, final DataSource dataSource) {
    env.lifecycle().addLifeCycleListener(new AbstractLifeCycleListener() {
        @Override
        public void lifeCycleStarting(LifeCycle event) {
            if (!(event instanceof Server)) {
                return;
            }

            Server server = (Server) event;
            JDBCSessionIdManager ids = jdbcSessionIdManager(server);
            server.setSessionIdManager(ids);
            env.servlets().setSessionHandler(new SessionHandler(jdbcSessionManager(ids)));
        }

        private JDBCSessionManager jdbcSessionManager(JDBCSessionIdManager idManager) {
            JDBCSessionManager m = new JDBCSessionManager();
            m.setSessionIdManager(idManager);
            return m;
        }

        private JDBCSessionIdManager jdbcSessionIdManager(Server server) {
            JDBCSessionIdManager m = new JDBCSessionIdManager(server);
            m.setWorkerName("");
            m.setDatasource(dataSource);
            return m;
        }
    });
}