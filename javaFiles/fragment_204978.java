public interface CourseRepo extends JpaRepository<Course, Integer> {
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
            "order by " +
            "  count(s) desc" +
            "", countQuery = "select count(c) from Course c")
    Page<CourseWithCountProjection> getProjectionWithCount(Pageable pageable);    
}