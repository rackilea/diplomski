enterButton.addListener(new ClickListener() {
    @Override
    public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
        return true;
    }

    @Override
    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
        if (isOver()) {
            if(validate(loginField.getText(), passField.getText())) {
                openMenu();
            }
        }
    }
});