String s = "153";
    int result = 0;

    for (char n : s.toCharArray())
        if (Character.isDigit(n))
            result += Math.pow(Character.getNumericValue(n), s.length());

    System.out.println(result);