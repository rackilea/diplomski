Body body = world.createBody(bodyDef);
body.setUserData(Checkpoint.COLOR_RED); //Set the Color of the Checkpoint as Body UserData

FixtureDef fixtureDef = new FixtureDef();
Fixture fixture = body.createFixture(fixtureDef);
fixture.setUserData(Type.CHECKPOINT); //Set the Type of the fixture to detect if it a Checkpoint