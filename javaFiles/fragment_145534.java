Map<String, String> properties = new HashMap<>();
    properties.put("height", "160");
    properties.put("weight", "80");
    properties.put("name", "bob");

    BeanWrapper person = new BeanWrapperImpl(new Person());
    for (Map.Entry<String, String> property : properties.entrySet()) {
        person.setPropertyValue(property.getKey(), property.getValue());
    }

    System.out.println(person.getWrappedInstance().toString());