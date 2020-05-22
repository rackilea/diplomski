public class App {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("machine");
        final StateMachine<States, Events> stateMachine = context.getBean(StateMachine.class);

        stateMachine.start();
        System.out.println(stateMachine.getState()); // ObjectState [getIds()=[STAY]

        stateMachine.sendEvent(Events.CLOSE_DOOR);
        System.out.println(stateMachine.getState()); // ObjectState [getIds()=[CLOSED_DOOR]

        stateMachine.sendEvent(Events.MOVE);
        System.out.println(stateMachine.getState()); // ObjectState [getIds()=[GOING]
    }
}