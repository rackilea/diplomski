Button button = new Button();
        button.setInputListener(new ButtonListener() {
                @Override
                public boolean keyDown(int keycode) {
                    return super.keyDown(keycode);
                }
            }
        );