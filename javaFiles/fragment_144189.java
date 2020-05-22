private Statement statement(final Statement base) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                before();
                try {
                    base.evaluate();
                } catch (Exception e) {
                    log.error("caught Exception", e);
                } finally {
                    after();
                }
            }
        };
    }