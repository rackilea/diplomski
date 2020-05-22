List cats = session.createCriteria(Cat.class)
     .createCriteria("kittens")
         .add( Restrictions.like("name", "Iz%") )
     .list();

 List cats = session.createCriteria(Cat.class)
     .createAlias("kittens", "kit")
     .add( Restrictions.like("kit.name", "Iz%") )
     .list();