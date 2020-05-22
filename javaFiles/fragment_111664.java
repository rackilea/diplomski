doubleInput = 0.0;
String inputStr = question.getText().toString();
try {
    doubleInput = Double.parseDouble(inputStr);
} catch (NumberFormatException e) {
    // This should probably do something more useful? i.e. tell
    // the user what they've done wrong...
    Log.e("Android",
                    "Double throws a NumberFormatException if you enter text that is not a number");
}