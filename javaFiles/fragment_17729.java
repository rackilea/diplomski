TextButton.TextButtonStyle buttonStyle = new TextButton.TextButtonStyle();
buttonStyle.font = new BitmapFont();
buttonStyle.font.scale(2f);
buttonStyle.fontColor = Color.WHITE;
buttonStyle.overFontColor = Color.LIGHT_GRAY;
buttonStyle.downFontColor = Color.GRAY;

newGameButton = new TextButton("New Game", buttonStyle);
continueButton = new TextButton("Continue", buttonStyle);
optionsButton = new TextButton("Options", buttonStyle);
exitButton = new TextButton("Exit", buttonStyle);

Table buttonGroup = new Table();
buttonGroup.setFillParent(true);
buttonGroup.align(Align.center);
buttonGroup.add(newGameButton);
buttonGroup.row();
buttonGroup.add(continueButton);
buttonGroup.row();
buttonGroup.add(optionsButton);
buttonGroup.row();
buttonGroup.add(exitButton);

stage.addActor(buttonGroup);

Controllers.addListener(new MenuControllerListener(buttonWrapper));