TextField name = new TextField();
personBinder.bind(name, "name");
add(name);

Button button = new Button("Save", e -> {
    if (personBinder.validate().isOk()) {
      Person p = personBinder.getBean();
      System.out.println(p.getName());
      System.out.println(p.getId());
    }
});
add(button);

Person p = new Person();
p.setName("John");
p.setId("42");

personBinder.setBean(p);