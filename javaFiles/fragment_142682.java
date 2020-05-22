TextButton button = new TextButton("Click", skin);
button.addListener(new ChangeListener() {
    @Override
    public void changed(ChangeEvent event, Actor actor) {
        System.out.println("Click Button");
        event.handle(); //set the event handled = true
    }
});

stage.addActor(button);