final List<Map<String, Object>> objects = new ArrayList<Map<String, Object>>();
objects.add(new HashMap<String, Object>());
objects.get(0).put("text", "This is my text value.");
objects.get(0).put("number", 10);
objects.add(new HashMap<String, Object>());
objects.get(1).put("text", "This is my second text value.");
objects.get(1).put("number", 20);

ArrayList<MyPojo> pojos = new ArrayList<MyPojo>();

for (Map<String, Object> objectMap : objects) {
    MyPojo pojo = new MyPojo();
    for (Entry<String, Object> property : objectMap.entrySet()) {
        Method setter = MyPojo.class.getMethod("set" + property.getKey().substring(0, 1).toUpperCase()
                + property.getKey().substring(1), property.getValue().getClass());
        setter.invoke(pojo, property.getValue());
    }
    pojos.add(pojo);
}

for (MyPojo pojo : pojos) {
    System.out.println(pojo.getText() + " " + pojo.getNumber());
}