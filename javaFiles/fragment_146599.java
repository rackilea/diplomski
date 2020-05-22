BackgroundSize backgroundSize = new BackgroundSize(900,
        700,
        true,
        true,
        true,
        false);
BackgroundImage image = new BackgroundImage(new Image("image/background.png"),
        BackgroundRepeat.NO_REPEAT,
        BackgroundRepeat.NO_REPEAT,
        BackgroundPosition.CENTER,
        backgroundSize);

HBoxName.setBackground(new Background(image));