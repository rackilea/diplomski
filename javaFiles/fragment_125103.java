String json = "{\n"
    + "  \"other_garbage\": \"hiya\",\n"
    + "  \"data\": [\n"
    + "    {\n"
    + "      \"num\": 5\n"
    + "    }\n"
    + "  ],\n"
    + "  \"meta\": 21\n"
    + "}";
Moshi moshi = new Moshi.Builder().add(new DataUnwrapperAdapterFactory()).build();
ParameterizedType type = Types.newParameterizedType(List.class, Data.class);
JsonAdapter<List<Data>> adapter = moshi.adapter(type);
List<Data> expected = adapter.fromJson(json);