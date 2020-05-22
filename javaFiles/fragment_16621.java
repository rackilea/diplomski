@Query(value = "SELECT professor.id, professor.department_id, " +
                    "professor.first_name, professor.last_name, " +
                    "professor.email, COUNT(professor_id) as count " +
                    "FROM professor LEFT JOIN student_internship ON professor.id = professor_id " +
                    "GROUP BY professor_id ORDER BY count DESC LIMIT =?1", nativeQuery = true)
    ArrayList<ITestProjection> findDataWithCount(Integer limit);