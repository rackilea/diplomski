//initialization
LabelStyle style = LabelStyle(bFont, Color.BLUE);
Label label = new Label("", style);
stage.addActor(label);

//in render
stage.act();
stage.draw();
label.setText("" + score);