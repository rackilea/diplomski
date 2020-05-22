class Entity {
    String type;
    List<Object> value = new ArrayList<>();
    ...
    public void addValue(Object valueToAdd){
        value.add(valueToAdd);
    }
}

...

Entity entity = new Entity();
entity.setType("both");
entity.addValue("numbercodes");
entity.addValue(Arrays.asList(1,2,3));