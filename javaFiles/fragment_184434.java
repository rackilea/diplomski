Map<String, String> data = new HashMap<>();
data.put("api_key", apiKey);
data.put("query", "avengers");
movieService.getSearchResults(data, new Callback<String>()
{
    @Override public void success(final String s, final Response response) {
    System.out.println(s);
    }

    @Override public void failure(final RetrofitError error) {
        LOGGER.log(Level.WARNING, error.getResponse().getReason());
    }
});