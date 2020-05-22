LinearLayout layout1 = new LinearLayout (this);
FrameLayout game = new FrameLayout(this);
DrawingView v = new DrawingView (this);

TextView myText = new TextView(this);

int w = getResources().getInteger(DrawingView.redColor);
Button redCircle = (Button) findViewById(w);



    redCircle.setWidth(300);
    redCircle.setText("Start Game");


layout1.addView(myText);
layout1.addView(redCircle); 
//redCircle.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

game.addView(v);
game.addView(layout1);