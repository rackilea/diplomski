String greeting = createGreeting(greetingFactory.get(customer.getTitle()), customer.getName());

// ... becomes ...
Title title = customer.getTitle();
String name = customer.getName();
String greeting = createGreeting(greetingFactory.get(title), name));