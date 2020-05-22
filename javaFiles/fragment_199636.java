public static void makeButtonScale (final Button button, final float hoverScale, final float pressedScale, final float duration){
    button.setTransform(true);
    button.addListener(new ClickListener(){
        void scaleTo (float targetScale){
            button.setOrigin(Align.center);
            button.clearActions();
            button.addAction(Actions.scaleTo(targetScale, targetScale, duration, Interpolation.fade));
        }

        public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
            super.touchDown(event, x, y, pointer, button);
            scaleTo(pressedScale);
            return true;
        }

        public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
            super.touchUp(event, x, y, pointer, button);
            scaleTo(isOver() ? hoverScale : 1f);
        }

        public void enter (InputEvent event, float x, float y, int pointer, Actor fromActor) {
            super.enter(event, x, y, pointer, fromActor);
            scaleTo(isPressed() ? pressedScale : hoverScale);
        }

        public void exit (InputEvent event, float x, float y, int pointer, Actor toActor) {
            super.exit(event, x, y, pointer, toActor);
            scaleTo(1f);
        }
    });