ObjectMapper mapper = new ObjectMapper();
Parent parent = mapper.readValue(json, Parent.class);

for (Child child : parent.getIntermediate().getChildren()) {
    System.out.println("Child: " + child.getName() + " is " + child.getAge() + " years old.");
}