private Result runTest(final Class<?> testClazz, final String methodName)
            throws InitializationError {
        BlockJUnit4ClassRunner runner = new BlockJUnit4ClassRunner(testClazz) {
            @Override
            protected List<FrameworkMethod> computeTestMethods() {
                try {
                    Method method = testClazz.getMethod(methodName);
                    return Arrays.asList(new FrameworkMethod(method));

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Result res = new Result();
        runner.run(res);
        return res;
    }

    class Result extends RunNotifier {
        Failure failure;

        @Override
        public void fireTestFailure(Failure failure) {
            this.failure = failure;
        };

        boolean isOK() {
            return failure == null;
        }

        public Failure getFailure() {
            return failure;
        }
    }