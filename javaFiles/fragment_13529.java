Response response = gson.fromJson((jsonString), Response.class);
    Collection<Result> res = response.getResults();
    for (Result result : res) {
        System.out.println(result.getAddressComponents());
        System.out.println(result.getFormattedAddress());
    }