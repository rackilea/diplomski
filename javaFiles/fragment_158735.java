Request request = new Request.Builder()
            .url(url)
            .build();

    client.newCall(request).enqueue(new Callback() {
        @Override
        public void onFailure(Request request, IOException e) {

        }

        @Override
        public void onResponse(Response response) throws IOException {
        // this is the callback which tells you the network call was successful, If like to make some changes to UI, you should call `runOnUiThread`.

        "YourClassName".this.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                }
            });
        }
    });