String raw = "1233983543587325318";

    int[] num = new int[raw.length()];

    for (int i = 0; i < raw.length(); i++){
        num[i] = raw.charAt(i) - '0';
    }

    for (int i : num) {
        System.out.println(i);
    }