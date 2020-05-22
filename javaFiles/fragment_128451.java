QBAuth.createSession(new QBCallbackImpl() {
            @Override
            public void onComplete(Result result) {
                if (result.isSuccess()) {
                    // do other requests here 
                    //
                } else {
                    handleErrors(result);
                }
            }
        });