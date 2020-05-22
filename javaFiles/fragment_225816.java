ListenableFuture<String> task = asyncTaskExecutor.submitListenable(new Callable<String>(){
                @Override
                public String call() throws Exception {
                    String result = sosQuery.test(oid);
                    logger.debug("result for sosQuery: " + result);
                    return result;
                }
            });