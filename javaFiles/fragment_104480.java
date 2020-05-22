musicButton.addListener(new ChangeListener() {
    @Override
    public void changed(ChangeEvent event, Actor actor) {
        if (!game.buttonClickSoundBool&&game.soundBool)
            buttonClickSound.play();
         musicStateManager.saveMusicState(!game.menuMusicBool);  // state inversed and saved in prefs
    }
});