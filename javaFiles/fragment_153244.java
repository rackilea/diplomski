private static Sprite fruitOne;
private static Sprite fruitTwo;
private static Sprite fruitThree;
. . .

//Other code in here

switch(textureNumber) {
  case 1:
    if (fruitOne == null) {
      fruit = new Sprite(x, 0, this.texture1);
    } else {
      fruit = fruitOne;
    }
    break;
  case 2:
    if (fruitTwo == null) {
      fruit = new Sprite(x, 0, this.texture2);
    } else {
      fruit = fruitTwo;
    }
    break;

   //Rest of code here. . .