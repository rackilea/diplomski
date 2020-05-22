@RunWith(MockitoJUnitRunner.class)
public class MyBeanTest {

  @Spy
  private Logger logger = LoggerProducer.getLogger();

  @InjectMocks
  private MyBean myTestBean; // = new MyBean(parameters). explicit if no default constructir

  @Test
  public void verifySomeLogic() {
    myTestBean.doSomething();
  }
}