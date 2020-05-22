new TestKit(system) {{
  final TestProbe probe = new TestProbe(system);

  final ActorRef underTest = system.actorOf(ServiceFSMActor.props(probe.ref()));
  underTest.tell(new Exception(), getRef());
  expectMsgEquals(ERROR);

  final Service state = probe.expectMsgClass(Service.class);
  assertEquals(ERROR, state.getServiceStatus());
}};