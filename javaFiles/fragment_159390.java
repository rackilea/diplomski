final RoadUser roadUser0 = context.mock(RoadUser.class, "roadUser0");
final RoadUser roadUser1 = context.mock(RoadUser.class, "roadUser1");
final RoadUser roadUser2 = context.mock(RoadUser.class, "roadUser2");

final RoadUserCreator roadUserCreator0 = context.mock(RoadUserCreator.class, "roadUserCreator0");
final RoadUserCreator roadUserCreator1 = context.mock(RoadUserCreator.class, "roadUserCreator1");

final RoadUserCreationDaemon daemon = new RoadUserCreationDaemon(null);
daemon.addRoadUserCreator(roadUserCreator0);
daemon.addRoadUserCreator(roadUserCreator1);        

context.checking(new Expectations() {{
    oneOf(roadUserCreator0).create(); will(returnValue(roadUsers(roadUser0, roadUser1)));
    oneOf(roadUserCreator1).create(); will(returnValue(roadUsers(roadUser2)));
}});

assertThat(daemon.createRoadUsers(), contains(roadUser0, roadUser1, roadUser2));