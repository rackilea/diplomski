@Query(value="SELECT COL_1"
              + ",COL_2"
              + ",COL_3"
              + "FROM TABLE_A"
              + "WHERE COL_1 = :col", nativeQuery = true)
List<Entity> getEntityDetails(@Param("col") String col); // it may not be a string - use the actual tyle of COL_1