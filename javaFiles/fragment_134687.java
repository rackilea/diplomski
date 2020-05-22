@Autowired
PersonService personService;
@Autowired
MutableAuthenticationService authenticationService;



public void createUser(User user) throws Exception {
    if (user.getUserName() != null) {
        if (authenticationService.authenticationExists(user.getUserName())) {
            throw new Exception("User" + user.getUserName() + " already exists.");
        } else {
            authenticationService.createAuthentication(user.getUserName(), user.getPassword().toCharArray());
            Map<QName, Serializable> properties = new HashMap<>();
            properties.put(ContentModel.PROP_USERNAME, user.getUserName());
            NodeRef personNodeRef = personService.createPerson(properties);
            user.setId(personNodeRef.getId());
        } 
    }
}