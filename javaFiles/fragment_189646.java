Student eswar= db.getStudentFromId(1);
    Set<Courses> c = eswar.getCourses();
    c.add(new Course("Science"));
    eswar.setCourses(c);

    session.saveOrUpdate(eswar);