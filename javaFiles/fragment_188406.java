okHttpClient.newCall(request1).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, Throwable throwable) {
                ...
            }

            @Override
            public void onResponse(Response response) throws IOException {
                ...
            }
        });