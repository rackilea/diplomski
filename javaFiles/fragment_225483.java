} else if (operator == 4) {
    if ((number1%number2==0) && (number1>number2)) {
        actualAnswer = number1 / number2;
    } else {
        generateNumbers();
    }
    equation.append(" / ");

}