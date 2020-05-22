Criteria cr=sn.createCriteria(PC.class);

    Criterion id=Restrictions.gt("id",11); // No need to cast as SimpleExpression implements Criterion
    Criterion os= Restrictions.ilike("os","d%");

    LogicalExpression and=Restrictions.and(id,os); 

    cr.add(and);