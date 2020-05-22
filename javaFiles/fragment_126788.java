detachedCriteria = DetachedCriteria.forClass(Task.class)
                   .createCriteria("Officer") // Officer property of task
                   .createCriteria("Company") // Company property of officer
                   .add(Restriction.eq(Key.COMPANY, compKey); // the company

List<Object> list = detachedCriteria
                    .getExecutableCriteria(hibernateSession)
                    .list();