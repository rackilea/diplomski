MyEntity myEntityExample = new MyEntity();
myEntityExample.setNumber(12);
myEntityExample.setName("AA");
myEntityExample.setFirstName("BB");
List<MyEntity> results = session.createCriteria(MyEntity.class)
    .add(Example.create(myEntityExample))
    .list();