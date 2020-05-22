@Query(
        value = "SELECT username, password, description, location, title, user_id FROM (institution INNER JOIN user ON institution.user_id = user.id) LEFT JOIN\n" +
                "(SELECT * FROM building_institutions WHERE building_institutions.building_id = 1) AS reserved_institutions\n" +
                "ON reserved_institutions.institutions_user_id = kits_nwt.institution.user_id\n" +
                "WHERE reserved_institutions.institutions_user_id IS null ORDER BY ?#{#pageable}",
        nativeQuery = true)
Page<Institution> findPotentialInstitutionsByBuildingId(Long userId, Pageable pageable);