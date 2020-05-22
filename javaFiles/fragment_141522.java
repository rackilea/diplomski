String input = "{\n" +
               "   \"name\" : \"Test\",\n" +
               "   \"runtime\" : \"\"\n" +
               "}";

GsonBuilder builder = new GsonBuilder();
builder.registerTypeAdapter(FooRuntime.class, new FooRuntimeTypeAdapter());
Gson gson = builder.create();
Foo foo = gson.fromJson(input, Foo.class);