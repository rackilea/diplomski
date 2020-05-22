Criteria criteria = currentSession.createCriteria(Professor.class, "professor");
    criteria.createAlias("professor.students", "student");
    criteria.createAlias("student.assigments", "assigment");
    criteria.add(Restrictions.eqProperty("professor.id", "student.profid"));
    criteria.add(Restrictions.eqProperty("assigment.studentid", "student.profid"));
    criteria.add(Restrictions.eq("id", 2411));
return criteria.list();