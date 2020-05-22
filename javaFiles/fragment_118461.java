try {
    double result1 = calc.calculate();
    String result = Double.toString(result1);
    txtCalc.setText(result);
    if (varX != 0) {
    btnFunX.setText("f(" + Double.toString((varX * 100) / 100) + ")");
        } catch (Exception e) {
            txtCalc.setText("Error!");      
                }