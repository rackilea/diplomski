@Autowired
private UserMapper userMapper;

@Test
public void testUserDAO(){

    Assert.assertNotNull(userMapper);
    UserDataResult userDataResult = userMapper.getUserData("ana.sandoval@pagosonline.com", 500101);

    Assert.assertNotNull(userDataResult);
    System.out.println("UserData: " + userDataResult.getUsuario_web_id() + " "
            + userDataResult.getEmail() + " "
            + userDataResult.getTipo_usuario_web() + " "
            + userDataResult.getNombres() + " "
            + userDataResult.getApellidos());
}