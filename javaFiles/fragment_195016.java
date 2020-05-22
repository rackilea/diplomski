Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .create();


Type listType = new TypeToken<ArrayList<TelephoneNumber>>() {}.getType();
List<TelephoneNumber> numbers = gson.fromJson(jsonArray, listType);