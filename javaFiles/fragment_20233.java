Person person = new Person();
DataBinder dataBinder = new DataBinder(person);
MutablePropertyValues mpv = new MutablePropertyValues();
mpv.add("name", "John Doe");
mpv.add("age", 25);
mpv.add("contact.street", "1st Street");
mpv.add("contact.number", 12345);
dataBinder.bind(mpv);