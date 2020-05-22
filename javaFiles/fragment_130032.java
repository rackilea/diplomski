public class RobotTest {

    @Test
    public void t1() throws Exception {
        ApplicationContext ctx = new 
                           AnnotationConfigApplicationContext(RobotConfig.class);
        RobotFactory rf = ctx.getBean(RobotFactory.class);
        assertThat(rf.newRobot("R2D2").toString(), 
           equalTo("RobotImpl [name_=R2D2] thins about an idea"));
    }

}