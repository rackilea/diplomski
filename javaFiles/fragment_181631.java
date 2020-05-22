@Override // In preSolve method. Not beginContact, it matters
public void preSolve(Contact contact, Manifold manifold) {
       short firstBit = contact.getFixtureA().getFilterData().categoryBits;
       short secondBit = contact.getFixtureB().getFilterData().categoryBits;

       if ((firstBit | secondBit) == (BOX_BIT | GROUND_BIT)) {
            System.out.println("Contact " + firstBit + " " + secondBit);
            contact.setEnabled(false);
       }
  }