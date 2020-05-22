RelativeLayout rl = new RelativeLayout(RelativeLayout.X_AXIS);
rl.setFill( true );
setLayout(rl);

...

add(Box.createHorizontalGlue(), new Float(1));
add(scrollPane);
add(Box.createHorizontalGlue(), new Float(1));