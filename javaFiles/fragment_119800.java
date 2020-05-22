int numRequests = 1;
    final CountDownLatch latch = new CountDownLatch(numRequests);

    HttpEntity entity = new NStringEntity(
            "{\n" +
                    "    \"user\" : \"kimchy\",\n" +
                    "    \"post_date\" : \"2009-11-15T14:12:12\",\n" +
                    "    \"message\" : \"trying out Elasticsearch\"\n" +
                    "}", ContentType.APPLICATION_JSON);

    List<HttpEntity> entities = asList(entity);

    for (int i = 0; i < numRequests; i++) {
        restClient.performRequestAsync(
                "PUT",
                "/twitter/tweet/" + i,
                Collections.<String, String>emptyMap(),
                entities.get(i),
                new ResponseListener() {
                    @Override
                    public void onSuccess(Response response) {
                        System.out.println(response);
                        latch.countDown();
                    }

                    @Override
                    public void onFailure(Exception exception) {
                        latch.countDown();
                    }
                }
        );
    }

    latch.await();