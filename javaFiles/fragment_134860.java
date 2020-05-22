String[] employeeNames = { "test", "test2" };
List<Survey> surveys = getSession().createCriteria(Survey.class).add(
        Restrictions.and
        (
            Restrictions.eq("surveyNumber", 1),
            Restrictions.in("employeeName", employeeNames)
        )
    ).list();