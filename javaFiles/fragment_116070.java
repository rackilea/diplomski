public void test(){
    ModelMapper mapper = new ModelMapper();
    mapper.getConfiguration().setFieldMatchingEnabled(true);
    mapper.getConfiguration().setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);


    FirstObject firstObject = new FirstObject();
    firstObject.setName("Hola");

    FirstObjectList firstObjectList = new FirstObjectList();
    firstObjectList.setId("1");

    firstObject.getObjectList().add(firstObjectList);

    SecondObject second = mapper.map(firstObject, SecondObject.class);

    assertEquals(firstObject.getName(), second.getName());

    assertEquals(firstObject.getObjectList().size(), second.getObjectList().size());    
    assertEquals(firstObject.getObjectList().get(0).getId(), second.getObjectList().get(0).getId());
}