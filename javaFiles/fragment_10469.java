BigDecimal firstNum = null, secondNum = null;
float firstFloat = -1, secondFloat = -1;

try {
    firstNum = new BigDecimal("4");
    firstFloat = firstNum.floatValue();
    secondNum = new BigDecimal("3");
    secondFloat = secondNum.floatValue();
} catch (NumberFormatException e) {
    e.printStackTrace();
}
float a = firstFloat / secondFloat;
tempview.setText(a + "");