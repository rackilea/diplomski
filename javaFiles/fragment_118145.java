static public class TestActor extends AbstractActor {
    private Integer number;

    public TestActor(Integer number) {
        this.number = number;
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .matchAny(message -> {
                    if (message instanceof SomeMessage) {
                        SomeMessage someMessage = (SomeMessage) message;
                        System.out.println("someMessage contains = " + someMessage.getAnotherNum());
                        context().sender().tell(new SomeMessage(number + someMessage.getAnotherNum()), context().self());
                    }
                }).build();
    }
}