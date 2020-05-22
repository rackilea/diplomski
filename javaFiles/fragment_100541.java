Button[] buttonArray = new Button[2];
buttonArray[0] = button1;
buttonArray[1] = button2;

Random r = new Random();

buttonArray[r.nextInt(2)].setText(someRandomText);