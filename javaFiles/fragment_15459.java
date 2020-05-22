Random rand = new Random();
View decorView = getWindow().getDecorVew();
int screenWidth = decorView.getWidth();
int screenHeight = decorView.getHeight();
...
// when you want to move the button.

view.setX(rand.nextInt(screenWidth - view.getWidth());
view.setY(rand.nextInt(screenHeight - view.getHeight());