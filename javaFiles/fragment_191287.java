String input = "123.456";
    String[] parts = input.split("\\.");
    String whole = parts[0];
    String fraction = parts[1];

    int wholeInt = Integer.parseInt(whole);
    int fractionInt = Integer.parseInt(fraction);
    int multiplier = pow10(fraction.length());
    int n = wholeInt * multiplier + fractionInt;
    int m = multiplier;

    System.out.println(n + "/" + m);