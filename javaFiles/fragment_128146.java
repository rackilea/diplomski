User user = new User();
Role role = new Role();

user.setUsername("john");
role.setName("Admin");
role.setId(Long.valueOf(1));
role.getUsers().add(user);


userService.saveUser(user);