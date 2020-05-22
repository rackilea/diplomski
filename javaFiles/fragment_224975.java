From Activity A

LoginAsyncTask customloginasync = new LoginAsyncTask(getActivity(),
                FATCH_USER_LIST, arglist);

        customloginasync.execute();

        customloginasync.setOnResultsListener(new AsyncTaskCompletedListener() {

            @Override
            public void OnResultSucceeded(String result, int asyncTaskNo) {

                Logger.logInfo("CustomLogin data=========" + result);

                ParseAvailableUserData(result);

            }
        });