public static void main(String[] args) {        
    List<Person> persons = new ArrayList<Person>();
    persons.add(new Person("John"));

    List<Address> adds = new ArrayList<Address>();
    adds.add(new Address("123 street"));
    adds.add(new Address("456 street"));

    persons.add(new Person(adds));

    Family family = new Family(persons);


    XStream stream = new XStream();     
    stream.registerConverter(new PersonConverter());
    stream.processAnnotations(new Class[]{Family.class});

    String xml = stream.toXML(family);
    System.out.println(xml);

    Family testFam = (Family) stream.fromXML(xml);
    System.out.println("family.equals(testFam) => "+family.equals(testFam));

}