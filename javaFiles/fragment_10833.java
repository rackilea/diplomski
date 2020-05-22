if(Future.class.isAssignableFrom(method.getReturnType())) {
            Callable<Object> methodRequest = () -> {
                Object res = method.invoke(delegate, args);
                return res;
            };
            Future<Object> future = scheduler.submit(methodRequest);
            scheduler.shutdown();
            result = future;
        }