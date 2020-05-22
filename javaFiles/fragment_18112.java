...
    b1.createFixture(fDef);

    shape.setAsBox(32/2, 32/2);
    fDef.shape = shape;
    fDef.friction = 1.0f; // <-- ADD THIS
    b2.createFixture(fDef);