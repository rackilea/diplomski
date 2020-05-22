runOnUiThread(new Runnable() {
    @Override
    public void run() {
        display2.setText("The factorial of " + fact + " is " + res);
        display1.setText("The string value is " + change);
    }
}