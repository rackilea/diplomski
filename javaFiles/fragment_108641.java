Gson gson = new Gson();
  Object object = gson.fromJson(arbitraryJson, Object.class);

  Wrapper w = new Wrapper();
  w.content = object;

  System.out.println(gson.toJson(w));