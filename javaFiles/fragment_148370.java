String str = "Cheese12";
    int count = 0;
    for (int i = 0; i < str.length(); i++) {
        if (Character.isDigit(str.charAt(i))) {
            count++;
        }
    }
    System.out.println(count);