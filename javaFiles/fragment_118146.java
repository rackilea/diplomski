@Test
public void should_alter_some_message() {
    // given
    ActorRef testActor = actorSystem.actorOf(Props.create(TestActor.class,10));
    TestJavaActor.SomeMessage someMessage = new SomeMessage(5);
    TestProbe testProbe = TestProbe.apply(actorSystem);

    // when
    testActor.tell(someMessage, testProbe.ref());

    // then
    testProbe.expectMsg(new SomeMessage(15));
}