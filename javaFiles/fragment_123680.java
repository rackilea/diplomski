public void updateNums(){
    final Random random = new Random();
    final int randval = random.nextInt(10 - 1 + 1) + 1;
    runOnUiThread(new Runnable() {
        @Override
        public void run() {
            final TextView num1 = (TextView) findViewById(R.id.num1);
            num1.setText(String.valueOf(randval));
            final TextView num2 = (TextView) findViewById(R.id.num2);
            num2.setText(String.valueOf(randval));
        }});
}