Criteria c = session.createCriteria(ProjectHasChief.class);
        c.createAlias("project", "project") //THIS ONE
        c.add(Restrictions.eq("chief", chief))
        c.add(Restrictions.disjunction()
                .add(Restrictions.like("project.designation", reg, MatchMode.ANYWHERE))
                .add(Restrictions.like("project.code", reg, MatchMode.ANYWHERE)));

List<ProjectHasChief> list = (List<ProjectHasChief>)c.list();