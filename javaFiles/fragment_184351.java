public void retrieveGlobalDataFromStorage(Context context)
{  
// ...  

    final GsonBuilder builder = new GsonBuilder()
       .registerTypeAdapter(LocalDate.class, new LocalDateSerializer())
       .registerTypeAdapter(LocalTime.class, new LocalTimeSerializer());
    final Gson gson = builder.create();  
// ...