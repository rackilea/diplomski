private static class Foo implements Func<JSONObject, B> {
  public B apply(JSONObject f) {
    try {
        JSONObject x = f.getJSONObject("bar");
        /* Whatever other code in here */
        return new B(); /* Place-holder */
    catch (JSONException e) {
        throw new RuntimeException("Could not get bar", e);
    }
  }
}