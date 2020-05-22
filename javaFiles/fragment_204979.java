public interface CourseRepo extends JpaRepository<Course, Integer> {
    @Query(value = "" +
        "select " +
        "  new Course(c.id, c.name, count(s)) " +
        "from " +
        "  Course c " +
        "  left join Student s on s.course.id = c.id " +
        "group by " +
        "  c " +
        "order by " +
        "  count(s) desc" +
        "", countQuery = "select count(c) from Course c")
    Page<Course> getCoursesWithCount(Pageable pageable);
}