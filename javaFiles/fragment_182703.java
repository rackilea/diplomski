@Query(
        value = "SELECT * FROM \n" +
                "(institution INNER JOIN user ON institution.user_id = user.id) \n" +
                "LEFT JOIN \n" +
                "(SELECT * FROM \n" +
                "building_institutions \n" +
                "WHERE building_id = :userId)\n" +
                " AS reserved_institutions \n" +
                "ON reserved_institutions.institutions_user_id = kits_nwt.institution.user_id \n" +
                " where reserved_institutions.institutions_user_id IS null \n"
                + "ORDER BY ?#{#pageable}"
        ,
        countQuery = "SELECT count(*) FROM \n" +
                "(institution INNER JOIN user ON institution.user_id = user.id) \n" +
                "LEFT JOIN \n" +
                "(SELECT * FROM \n" +
                "building_institutions \n" +
                "WHERE building_id =:userId)\n" +
                " AS reserved_institutions \n" +
                "ON reserved_institutions.institutions_user_id = kits_nwt.institution.user_id \n" +
                "where reserved_institutions.institutions_user_id IS null \n" +
                "ORDER BY ?#{#pageable}",
        nativeQuery = true)
Page<Institution> findPotentialInstitutionsByBuildingId(@Param("userId") Long userId, Pageable pageable);