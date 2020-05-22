@Query(value = "" +
        "select " +
        "  c.id as id, " +
        "  c.name as name, " +
        "  count(s) as total " +
        "from " +
        "  Course c " +
        "  left join Student s on s.course.id = c.id " +
        "group by " +
        "  c " +
        "", countQuery = "select count(c) from Course c")
Page<CourseWithCountProjection> getProjectionWithCount(Pageable pageable);

Page<CourseWithCountProjection> result = parentRepo.getProjectionWithCount(PageRequest.of(0, 20, Sort.by(Sort.Direction.DESC, "total")));