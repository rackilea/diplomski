String number = "2147483649";
    String int_max = "2147483647";

    if (number.length() > int_max.length())
    {
        System.out.println("OVERFLOW");
    }
    else if (number.length() == int_max.length()){
        int comparison = number.compareTo(int_max);
        System.out.println(comparison > 0 ? "OVERFLOW" : "");
    }