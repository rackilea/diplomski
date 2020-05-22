@Query("Select t from Data t " +
        "where " +
        "(:name IS NULL or t.name like :name) AND " +
        "(:age IS NULL or t.age = :age) AND " +
        "(:address IS NULL or t.address = :address) AND " +
        "(:etc IS NULL or t.etc= :etc)")
@RestResource(path = "all", rel = "all")
Page findByAll(@Param("name") String name, @Param("age") String age,
        @Param("address") String address, @Param("etc") String etc, Page page);