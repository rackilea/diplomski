URL url = new HttpUrl.Builder()
        .scheme("http")
        .host("your_domain")
        .addPathSegments("your_path")
        .addQueryParameter("param1", "value1")
        .build()
        .url();