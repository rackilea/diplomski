// Transaction 1
Role role = new Role( "ADMIN" );
session.save( role );

// Transaction 2
User user = new User( "Naros" );
user.getRoles().add( roleService.getRoleByName( "ADMIN" ) );
session.save( user );