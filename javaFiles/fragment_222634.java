configuration.setSessionFactoryObserver(
        new SessionFactoryObserver() {
            @Override
            public void sessionFactoryCreated(SessionFactory factory) {}
            @Override
            public void sessionFactoryClosed(SessionFactory factory) {
                ((StandardServiceRegistryImpl) serviceRegistry).destroy();
            }
        }
);