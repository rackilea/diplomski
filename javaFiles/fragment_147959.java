final DataReadRequest readRequest = querySessionData();
Fitness.HistoryApi.readData(mClient, readRequest).setResultCallback(new ResultCallback<DataReadResult>() {
        @Override
        public void onResult(@NonNull DataReadResult dataReadResult) {
            //do your stuff!!
        }
     });
 }