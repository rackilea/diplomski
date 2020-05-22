Alice alice = new Alice();
Bob bob = new Bob();
bob.setNumber(3);
alice.setBob(bob);

ObjectMapper mapper = new ObjectMapper();

Alice alice1 = mapper.readValue(mapper.writeValueAsString(alice), Alice.class);