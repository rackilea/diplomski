int temprature = 0;
try {
    temprature = Integer.parseInt(Temprature.getText().toString());
} catch (NumberFormatException e) {
   // Log error, change value of temperature, or do nothing
}