/**paddle1**/
    BodyDef paddleDef = new BodyDef();
    paddleDef.type = BodyType.DynamicBody;
    paddleDef.position.set(width * 0.2f, height / 2);
    paddleDef.fixedRotation = true;

    Body paddleBody = world.createBody(paddleDef);
    paddleBody.setUserData(4);

    PolygonShape paddleShape = new PolygonShape();
    paddleShape.setAsBox(3.0f, 15.0f); //half-width and half-height

    FixtureDef paddleFD = new FixtureDef();
    paddleFD.shape = paddleShape;
    paddleFD.density = 10.0f;
    paddleFD.friction = 0.0f;
    paddleFD.restitution = 0.1f;

    paddleBody.createFixture(paddleFD);

    paddleShape.dispose();

    paddleBody.setLinearVelocity(0.0f, 0.0f);
    /**end paddle1**/

    /**paddle2**/
    BodyDef paddleDef2 = new BodyDef();
    paddleDef2.type = BodyType.DynamicBody;
    paddleDef2.position.set(width * 0.8f, height / 2);
    paddleDef2.fixedRotation = true;        

    Body paddleBody2 = world.createBody(paddleDef2);
    paddleBody2.setUserData(5);             

    PolygonShape paddleShape2 = new PolygonShape();
    paddleShape2.setAsBox(3.0f, 15.0f); //half-width and half-height

    FixtureDef paddleFD2 = new FixtureDef();
    paddleFD2.shape = paddleShape2;
    paddleFD2.density = 10.0f;
    paddleFD2.friction = 0.0f;
    paddleFD2.restitution = 0.1f;

    paddleBody2.createFixture(paddleFD2);

    paddleShape2.dispose();

    paddleBody2.setLinearVelocity(0.0f, 0.0f); // Move nowhere at a rate of x = 0.0f, y = 0.0f meters per second
    /**end paddle2**/