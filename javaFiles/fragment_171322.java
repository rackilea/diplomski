public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

    Game.resources.getSound("click_2").play();

    if (saveBox.isVisible()) {

        saveBox.setVisible(false); 
        okButtonReference.setStyle(unclickedTextButtonStyle) // Not-clicked TextButtonStyle as parameter

        cancelButtonReference.setStyle(unclickedTextButtonStyle) // Not clicked TextButtonStyle as parameter.
        return false;
    }
    saveBox.setVisible(true);

    return true;
}