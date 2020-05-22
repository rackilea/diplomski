public void beginContact(Contact contact) {
        Fixture fa = contact.getFixtureA();
        Fixture fb = contact.getFixtureB();

        Gdx.app.postRunnable(new Runnable() {

                @Override
                public void run () {
                    fb.getBody().setTransform(10f, 0f, 0f);
                }
        });
}