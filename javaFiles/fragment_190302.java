@Query(value="SELECT COL_1"
              + ",COL_2"
              + ",COL_3"
              + "FROM TABLE_A"
              + "WHERE COL_1 = :COL_1_1001", nativeQuery = true)
List<Entity> getEntityDetails();