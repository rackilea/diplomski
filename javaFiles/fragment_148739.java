String text = "121";
    int result = 0;
    for (char c : text.toCharArray()) {
        result += Integer.parseInt(Character.toString(c));
    }

    System.out.println(result);