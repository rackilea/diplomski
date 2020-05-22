@Before
public void setup() throws Exception {
    fixture = Fixtures.newGivenWhenThenFixture(User.class);
    UserCommandHandler target = (UserCommandHandler) ((Advised) userCommandHandler).getTargetSource().getTarget();
    fixture.registerAnnotatedCommandHandler(target);
}