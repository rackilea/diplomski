builder.registerTypeAdapter(Date::class.java, JsonDeserializer<Date> { 
    json, typeOfT, context ->
    if (json.getAsJsonPrimitive().isNumber())
        Date(json.asJsonPrimitive.asLong * 1000) else
        null
})