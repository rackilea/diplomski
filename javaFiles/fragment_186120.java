public void onCalculate() {
    float input = 0.0;
    if (editText.getText().toString().equals("")) {
         //Text is empty do nothing
    } else {
         //parse your value
         input = Float.parseFloat(editText.getText().toString());
    }
}