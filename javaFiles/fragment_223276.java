final FileDownloadService downloadService =
            ServiceGenerator.createService(FileDownloadService.class);

    Call<ResponseBody> call =
            downloadService.downloadFileWithDynamicUrlSync(fileUrl);
    call.enqueue(new Callback<ResponseBody>() {
        @Override
        public void onResponse(Call<ResponseBody> call, final Response<ResponseBody>
                response) {
            if (response.isSuccessful()) {
                Log.d(TAG, "server contacted and has file");

                new AsyncTask<Void, Void, Void>() {
                    @Override
                    protected Void doInBackground(Void... voids) {
                        boolean writtenToDisk = writeResponseBodyToDisk(FileDownloadActivity.this, response.body(), null);

                        Log.d(TAG, "file download was a success? " + writtenToDisk);
                        return null;
                    }
                }.execute();
            } else {
                Log.d(TAG, "server contact failed");
            }
        }