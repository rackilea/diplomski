class MyActivity extends Activity {

    public void myMethod() {
       MyClickHandler handler = new MyClickHandler();
        Button[] buttons = getAllOneHundredButtonsAsArray();
        for (Button button : buttons) {
            button.setOnClickListener(handler);
        }
    }

    class MyClickHandler implements View.OnClickListener {
        public void onClick(View v) {
            showToast(((Button) v).getText());
        }
    }
}