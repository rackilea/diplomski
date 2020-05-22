String[] numbersToEvaluate = new String[]{"11100111", "100101", "10101101"};

for (String num: numbersToEvaluate)
{
    number = Integer.parseInt(num);

    digit1 = ((number % 100000000) - (number % 10000000 % 10000000)) / 10000000;
    digit2 = ((number % 10000000) - (number % 10000000 % 1000000)) / 1000000;
    digit3 = ((number % 1000000) - (number % 1000000 % 100000)) / 100000;
    digit4 = ((number % 100000) - (number % 100000 % 10000)) / 10000;
    digit5 = ((number % 10000) - (number % 10000 % 1000)) / 1000;
    digit6 = ((number % 1000) - (number % 1000 % 100)) / 100;
    digit7 = ((number % 100) - (number % 100 % 10)) / 10;
    digit8 = (number % 10);

    result = (digit1 * -128) + (digit2 * 64) + (digit3 * 32) + (digit4 * 16) + (digit5 * 8) + (digit6 * 4) + (digit7 * 2) + (digit8 * 1);

    System.out.println ( "Binary number: " + num + "\nDecimal Number: " + result);
}