if (keyboard.nextInt() < 1) {
  throw new Exception("Number must be higher than 0!");
}
else health = keyboard.nextInt();
Board b = new Board();
b.setHealth(health);