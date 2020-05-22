private static Body createPhysicBodies(Array<Vector2> input, World world) {
    BodyDef bodyDef = new BodyDef();
    bodyDef.type = BodyType.DynamicBody;
    Body body = world.createBody(bodyDef);
    for (int i = 0; i < input.size - 1; i++) {
        Vector2 point = input.get(i);
        Vector2 dir = input.get(i + 1).cpy().sub(point);
        float distance = dir.len();
        float angle = dir.angle() * MathUtils.degreesToRadians;
        PolygonShape shape = new PolygonShape();    
        shape.setAsBox(distance / 2, Constants.THICKNESS / 2, dir.cpy()
                .scl(0.5f).add(point), angle);
        body.createFixture(shape, 1.0f);
    }
    return body;
}