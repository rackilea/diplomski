File httpCacheDirectory = new File(context.getCacheDir(), "responses");

        Cache cache = null;
        try {
            cache = new Cache(httpCacheDirectory, 10 * 1024 * 1024);
        } catch (IOException e) {
            Log.e("OKHttp", "Could not create http cache", e);
        }

        OkHttpClient okHttpClient = new OkHttpClient();
        if (cache != null) {
            okHttpClient.setCache(cache);
        }
        String hostURL = context.getString(R.string.host_url);

        api = new RestAdapter.Builder()
                .setEndpoint(hostURL)
                .setClient(new OkClient(okHttpClient))
                .setRequestInterceptor(/*rest of the answer here */)
                .build()
                .create(MyApi.class);