private static final float DAMP = 10f;
private static final float MAX_VEL = 3f;

(...)

public void update(float delta) {

    (...)

    // apply damping to halt Bob nicely 
    float decel = DAMP*delta;
    if (Math.abs(bob.getVelocity().x) < decel) {
        bob.getVelocity().x = 0;
    } else {
        bob.getVelocity().x -= decel*(bob.getVelocity().x < 0 ? -1 : 1);
    }

    (...)

    // checking collisions with the surrounding blocks depending on Bob's velocity
    checkCollisions(delta);

    // simply updates the state time
    bob.update(delta);
}