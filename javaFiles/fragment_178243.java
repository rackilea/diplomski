@Autowired
UserDao userDao;

@Autowired
UserServiceImpl userService;

@Test
public void verifySpringContext() {
    assertNotNull(userDao);
    assertNotNull(userService.getUserDao());
}