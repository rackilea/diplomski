Role role = new Role();
role.setId(1);
role.setName("TestRole");

Role r = (Role) statementContext.getAttribute("role");
boolean equals = e.equals(role);