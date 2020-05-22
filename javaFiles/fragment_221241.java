public ApplicationListener getApplicationListener () {


        setLoadingListener(new LoadingListener(){

            @Override
            public void beforeSetup() {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterSetup() {
                // TODO Auto-generated method stub
                wrapper = new GWTWrapper();
                client.setPlatform(wrapper);
            }

        });
            return client;