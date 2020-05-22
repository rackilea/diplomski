public class CollisionController implements ContactListener {

private boolean collided;

...


@Override
public void beginContact(Contact contact) {
    collided = false;
}

@Override
public void endContact(Contact contact) {
    if (!collided && contact.getFixtureA().getUserData() != null && contact.getFixtureB().getUserData() != null) {
        // CODE
        collided = true;
    }
}

...