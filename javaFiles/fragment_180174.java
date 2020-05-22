List<Integer> values=new ArrayList<Integer>();
values.add(1);
values.add(2);
values.add(3);

DetachedCriteria subQuery = DetachedCriteria.forClass(B.class, "b").
            .add(Restrictions.eqProperty("b.id", "a.parent"))
            .setProjection(Projections.property("b.prop")).
            .add(Restrictions.in("b.prop", values);