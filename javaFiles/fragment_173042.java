@Autowired
  private UserDao userDao;

  @RequestMapping(method = RequestMethod.GET, value="/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE})
ResponseEntity<User> getUser(@PathVariable int userId){
    User u = userDao.getUser(userId);
    return new ResponseEntity<User>(u, HttpStatus.OK);
}