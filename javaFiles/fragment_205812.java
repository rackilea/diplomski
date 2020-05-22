...
    studentQuery = em.createQuery(query, StudentEntity.class);
    studentEntityList = studentQuery.getResultList();
    courseEntity = em.find(CourseEntity.class,courseId);
    courseEntity.setStudentList(studentEntityList); // replacing the previous Collection by the one you retrieved by querying the DB !!! 
    em.merge(courseEntity);
    ...