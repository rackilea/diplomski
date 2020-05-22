public Response getMsg(@QueryParam("email") String email,
                       @QueryParam("pretty") String pretty
) throws JSONException {
   try(JedisWrapper jw = ...) {
      Jedis jedis = jw.get();
      ...
   }