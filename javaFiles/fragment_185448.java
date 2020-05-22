int xPanel = getWidth();
int yPanel = getHeight();

int sizeCircleOne = 40;
int sizeCircleTwo = 10;

// Drawing circle 1
g.setColor(Color.BLUE);
g.fillOval(
 xPanel/2 - sizeCircleOne/2,
 yPanel/2 - sizeCircleOne/2,
 sizeCircleOne,
 sizeCircleOne
);

// Drawing circle 2
g.setColor(Color.RED);
g.fillOval(
 xPanel/2 - sizeCircleTwo/2,
 yPanel/2 - sizeCircleTwo/2,
 sizeCircleTwo,
 sizeCircleTwo
);