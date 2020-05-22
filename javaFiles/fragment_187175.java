new GetStuffAsyncly(message, this, new AsyncListener() {
            @Override
            public void onTaskStarted() {
                //do your stuff
            }

            @Override
            public void onTaskFinished(String data) {
//Do your stuff;
            }
        }).execute(parameter);