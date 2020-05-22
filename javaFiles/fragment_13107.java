try {
    ObjectMapper mapper = new ObjectMapper();

    InputStream jsonFileStream = context.getAssets().open("categories.json");

    Category[] categories = (Category[]) mapper.readValue(jsonFileStream, Category[].class);

    Log.d(tag, "Found "  + String.valueOf(categories.length) + " categories!!");
} catch (Exception e){
    Log.e(tag, "Exception", e);
}