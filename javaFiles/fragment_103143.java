@OnClick({ R.id.button1, R.id.button, R.id.button})//as many you want
public void onButtonClick(Button button) {
  if (button.getText().equals("correctText")) {
    //Do whatever you want
  } else {
    Toast.makeText(this, "message", LENGTH_SHORT).show();
  }
}