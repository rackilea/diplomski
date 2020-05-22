@RequestMapping(method = RequestMethod.GET, value="/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE})
ResponseEntity<User> getUser(@PathVariable int userId){
    UserDaoImpl user = new UserDaoImpl(); // <-- HERE
    User u = new User();
    u=user.getUser(userId);
    return new ResponseEntity<User>(u, HttpStatus.OK);
}