JsonNode tree = mapper.readTree(jsonString);
    Iterator<JsonNode> iter = tree.path("data").getElements();
    while (iter.hasNext()){
        JsonNode node = iter.next();
        Person person = mapper.readValue(node.path("Person"), Person.class);
        Dog dog = mapper.readValue(node.path("Dog"), Dog.class);
        MyNewClass myNewClass = new MyNewClass(person , dog);
        ... //Do something with it
    }