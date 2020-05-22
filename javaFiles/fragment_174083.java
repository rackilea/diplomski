int[] gravities = new int[4];
gravities[0] = Gravity.BOTTOM;
gravities[1] = Gravity.TOP;
gravities[2] = Gravity.LEFT;
gravities[3] = Gravity.RIGHT;

if (check.contains("WTF")) {
    Random random = new Random();
    display.setText("WTF!!!1!");
    display.setTextSize(random .nextInt(30));
    display.setTextColor(Color.rgb(random.nextInt(256),
                                  random.nextInt(256),
                                  random.nextInt(256)));
    //from 0 to gravities.length get a random number
    int randomIndex = random.nextInt(gravities.length);
    //which will be some random gravity constant
    int randomGravity = gravities[randomIndex];
    display.setGravity(randomGravity);
}