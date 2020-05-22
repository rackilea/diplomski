String s1 = "taco cat";
    boolean palindrome = true;

    s1 = s1.replaceAll("\\s", "");
    char[] arr = s1.toCharArray();

    for (int i = 0; i < arr.length / 2; ++i) {
        if (arr[i] != arr[(arr.length - 1) - i]) {
            palindrome = false;
            break;
        }
    }
    System.out.println("Is palindrome: " + palindrome);