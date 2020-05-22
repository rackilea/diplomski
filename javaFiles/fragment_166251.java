@Override
    public void beginContact(Contact contact) {
        String userDataA = contact.getFixtureA().getBody().getUserData().toString();
        String userDataB = contact.getFixtureB().getBody().getUserData().toString();

        if(userDataA.equals("player") && userDataB.equals("otherEntity")){
            colliding = true;
            //do stuffs when collision has started
        } else if(userDataB.equals("player") && userDataA.equals("otherEntity")){
            colliding = true;
            //do stuffs when collision has started
        }
        System.out.println("Contact detected");
    }