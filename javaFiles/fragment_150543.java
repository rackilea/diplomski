mapping(MyEntityA.class, MyEntityB.class)
.fields("myEntityList", "myStringList",
    hintA(MyEntity.class),
    hintB(String.class));

mapping(MyEntity.class, String.class)
.fields(this_(), this_(), customConverter(MyEntityToStringConverter.class));