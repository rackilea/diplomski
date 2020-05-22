String responseBody = response.body().string();

                //-----------------------differs-------------------------
                final T obj = worker.run(responseBody);
                //------------------------------------------------------

                handler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        //---------------------------------------last parameter differs----------------------------------------------
                        callback.onSuccess(new HTTPTransaction(response.code(), response.message(), response.header("ETag")), obj);
                        //-----------------------------------------------------------------------------------------------------------
                    }
                });