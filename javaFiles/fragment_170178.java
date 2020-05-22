private void setContactListener() {
    world.setContactListener(new ContactAdapter() {

        @Override
        public void preSolve(Contact contact, Manifold manifold) {
            Body bodyA = contact.getFixtureA().getBody();
            Body bodyB = contact.getFixtureB().getBody();

            if (bodyA == mother.getBody()) virusInvolved(bodyA, bodyB);
            else if (bodyB == mother.getBody()) virusInvolved(bodyB, bodyA);
        }

        private void virusInvolved(Body motherCellBody, Body virusBody) {
            VirusEntity virus = null;
            for (VirusEntity v : viruses) {
                if (v.getBody() == virusBody) virus = v;
            }
            if (virus != null) {
                virus.setMovementAllowed(false);
                virus.remove();
            }
        }
    });
}