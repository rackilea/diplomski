@POST("api/Search/Vendor/Multiple")
    Call<String> getVendors(
            @Query("take") int take,
            @Query("page") int page,
            @Body Body json
    );