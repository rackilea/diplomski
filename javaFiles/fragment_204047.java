while(iterator.hasNext()){
                DeferredResult<String> result = iterator.next();
                System.out.println("Setting result.");
                if(!result.isSetOrExpired()){
                    result.setResult("Somebody clicked the thing! Click count: " + clickCount);
                }
                iterator.remove();
            }