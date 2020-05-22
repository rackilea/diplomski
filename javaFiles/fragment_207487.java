Course course = ...;

List<Student> honourableStudents = entityManager.createQuery(
        "select s " +
        "from Student s " +
        "where s.graduatedWithHonor = true " +
        "and s.course = :course", Student.class)
.setParameter("course", course)
.getResultList();