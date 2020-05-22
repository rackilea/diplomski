final WidgetGroup parent = new WidgetGroup();

InputListener inputListener = new InputListener(){
    private final Vector2 tmp = new Vector2();

    public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
        return true;
    }

    public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
        event.getTargetActor().localToParentCoordinates(tmp.set(x, y));
        Actor releaseOverActor = parent.hit(tmp.x, tmp.y, true);
        if (releaseOverActor != null){
            //doSomethingTo(releaseOverActor);
        }
    }
}

for (Actor clickable : clickableActors){
    parent.add(clickable);
    clickable.addListener(inputListener);
}