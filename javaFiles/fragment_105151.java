...

@Autowired
private WebApplicationContext context;

@RequestMapping(method = RequestMethod.POST)
@ResponseBody
public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO data) {
    UserDomain user = this.mapper.map(data, getUserDomain());
    UserDomain createdUser = this.service.createUser(user);
    UserResponseDTO createdUserDTO = this.mapper.map(createdUser, UserResponseDTO.class);
    return new ResponseEntity<UserResponseDTO>(createdUserDTO, HttpStatus.CREATED);
}

private UserDomain getUserDomain() {
    return context.getBean(UserDomain.class);
}

...