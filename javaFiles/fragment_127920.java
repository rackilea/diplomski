List results = session.createCriteria(CarSearchList.class)
    .add(Example.create(instance))
    .createAlias("car", "car")
    .createAlias("user", "user")
    .add( Restrictions.eqProperty("car.carId",    "user.userId"))
    .list();