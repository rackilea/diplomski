// read YAML file
User user = objectMapper.readValue(new File("user.yaml"), User.class);

// modify the address
Address address = user.getAddress();
address.setLine1("Your address line 1");
address.setLine2("Your address line 2");
address.setCity("Bangalore");
address.setZip(560010);

// write YAML file
objectMapper.writeValue(new File("user-modified.yaml"), user);