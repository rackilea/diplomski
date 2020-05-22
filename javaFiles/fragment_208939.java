UriComponents uriComponents =
            UriComponentsBuilder.newInstance()
                    .scheme("https")
                    .host("api.stackexchange.com")
                    .path("/2.2/users")
                    .queryParam("order", "desc")
                    .queryParam("sort", "reputation")
                    .queryParam("inname", fullName)
                    .queryParam("site", "stackoverflow")
                    .build()
                    .encode();

    OkHttpClient client = new OkHttpClient();

    Request request = new Request.Builder()
            .url(uriComponents.toUriString())
            .get()
            .addHeader("cache-control", "no-cache")
            .build();

    Response response = client.newCall(request).execute();
    return new JSONObject(response.body().string());