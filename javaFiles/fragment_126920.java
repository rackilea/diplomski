interface Api1 {
    @GET("/api1") Observable<List<Item>> items(@Query("param") String param);
}

interface Api2 {
    @GET("/api2/{item_id}") Observable<ItemExtended> extendedInfo(@Path("item_id") String item_id);
}