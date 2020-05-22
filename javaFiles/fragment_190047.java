//define the Contact listener
public class MyContactListener implements ContactListener{

    @Override
    public void beginContact(Contact contact){
        if ((String)contact.getFixtureA().getUserData()=="trap" || (String)contact.getFixtureB().getUserData()=="trap")
            //hurt player
    }

    @Override public void endContact(Contact contact){}
    @Override public void preSolve(Contact contact, Manifold oldManifold){}
    @Override public void postSolve(Contact contact, ContactImpulse impulse){}
};