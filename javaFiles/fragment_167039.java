public static void getGoogle(final IAPICallback callback) {
        new Thread(new Runnable() {

            @Override
            public void run() {

                RestAdapter.Builder builder = new RestAdapter.Builder()
                        .setEndpoint("http://google.com")
                        .setClient(new OkClient(new OkHttpClient()));
                RestAdapter adapter = builder.build();
                ITaskAPI service = (ITaskAPI) adapter.create(ITaskAPI.class);

                Response result = service.getGoogle();

                APIResponse response;

                if(result.getStatus() == 200) {
                    response = new APIResponse(true, "it worked!");
                }else{
                    response = new APIResponse(false, "boo! bad dog!");
                }

                callback.done(response);
            }
        }).start();
    }