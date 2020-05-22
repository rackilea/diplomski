protected void pickRandomButton() {
    // TODO Auto-generated method stub
    randomButtonId = "";

    Random randomGenerator = new Random(); // construct a new random number generator
    int randomNumber = randomGenerator.nextInt(3);

    randomButtonId = "button" + (randomNumber +1);
    Log.d(TAG, randomButtonId, null);

    int buttonId = getResources().getIdentifier(randomButtonId, "id", getPackageName());
    Button activeMole = (Button) findViewById(buttonId);
    activeMole.setBackgroundResource(color.red);
}