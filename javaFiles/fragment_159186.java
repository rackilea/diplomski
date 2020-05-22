//pause/playAction
button.addListener(new ChangeListener() {
    @Override
    public void changed (ChangeEvent event, Actor actor) {
        if (button.isChecked())
            resume();
        else
            play();
    }
});