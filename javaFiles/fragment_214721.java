private void initCard(Context context) {
    lblNumber = new TextView(context);
    lblNumber.setBackgroundColor(res.getColor(R.color.light_brown));

    randomGenerator = new Random();
    int r = randomGenerator.nextInt(2);

    if(r == 0)
        this.number = 2;
    else
        this.number = 4;

    addView(lblNumber);
}