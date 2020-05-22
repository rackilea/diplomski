Criteria criteria = getSeession().createCriteria(Example.class, "example");

    Aliases aliases = Aliases.create()
        .add("example.test", "test", JoinType.INNER);
    criteria.add(Restrictions.eq("test", "test_value"));

    aliases.addToCriteria(criteria); // add aliases to the criteria

    List<Example> examples = criteria.list();