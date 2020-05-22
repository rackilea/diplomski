XStream xstream = new XStream();
    xstream.alias("person", Person.class);
    xstream.alias("persons", PersonList.class);
    xstream.addImplicitCollection(PersonList.class, "list");

    PersonList list = new PersonList();
    list.add(new Person("ABC",12,"address"));
    list.add(new Person("XYZ",20,"address2"));

    String xml = xstream.toXML(list);