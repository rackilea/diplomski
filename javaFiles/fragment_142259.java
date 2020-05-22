for (int i = 0; i < 10; i++){
    int randomInt = ran.nextInt(values.size());

    TestObject obj = new TestObject();
    obj.setName(values.get(randomInt).getName());

    tempList.add(obj);
}