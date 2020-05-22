Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return textview != null;
            }
        });