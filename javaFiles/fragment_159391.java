final RoadUserContainer roadUserContainer0 = context.mock(RoadUserContainer.class, "roadUserContainer0");
final RoadUserContainer roadUserContainer1 = context.mock(RoadUserContainer.class, "roadUserContainer1");

final RoadUserContainer resultRoadUserContainer = context.mock(RoadUserContainer.class, "resultRoadUserContainer");

final RoadUserCreator roadUserCreator0 = context.mock(RoadUserCreator.class, "roadUserCreator0");
final RoadUserCreator roadUserCreator1 = context.mock(RoadUserCreator.class, "roadUserCreator1");

final RoadUserCreationDaemon daemon = new RoadUserCreationDaemon(null);
daemon.addRoadUserCreator(roadUserCreator0);
daemon.addRoadUserCreator(roadUserCreator1);

context.checking(new Expectations() {
    {
        oneOf(roadUserCreator0).create();
        will(returnValue(roadUserContainer0));
        oneOf(roadUserCreator1).create();
        will(returnValue(roadUserContainer1));

        oneOf(resultRoadUserContainer).addAll(roadUserContainer0);
        oneOf(resultRoadUserContainer).addAll(roadUserContainer1);
    }
});

daemon.createRoadUsers(resultRoadUserContainer);