int ph_value = Integer.parseInt(ph_value.getText().toString());
int colorHazen = Integer.parseInt(colorHazen.getText().toString());
int otherElement = Integer.parseInt(other_element.getText().toString());
int turbidity = Integer.parseInt(turbidity.getText().toString());
int phLow = 6.5;
int phHigh = 8.5;
int colorLow = 5;
int colorHigh = 15;
int turbLow = 1;
int turbHigh = 5;
int otherLow = 500;
int otherHigh = 2000;

if (ph_value > phLow && ph_value < phHigh &&
    colorHazen > colorLow && colorHazen < colorHigh &&
    otherElement > otherLow && otherElement < otherHigh &&
    turbidity > turbLow && turbidity < turbHigh) {

    Toast.makeText(this, "water is drinkable.", Toast.LENGTH_SHORT).show();
}
else {
    Toast.makeText(this, "water is not for drinking purpose.",
        Toast.LENGTH_SHORT).show();
}