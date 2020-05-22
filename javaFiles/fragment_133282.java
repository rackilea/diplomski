leftImg.addListener(new InputListener() {

        @Override
        public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
            player.getComponent(MovementComponent.class).setGoLeft(true);
            super.enter(event, x, y, pointer, fromActor);
        }

        @Override
        public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
            player.getComponent(MovementComponent.class).setGoLeft(false);
            super.exit(event, x, y, pointer, toActor);
        }
    });