String input = "[{\"KEY1\" :\"VALUE1\",\"KEY2\" :\"VALUE2\",\"KEY3\" :\"VALUE3\",\"KEY4\" :\"VALUE4\"},{\"KEY1\" :\"VALUE5\",\"KEY2\" :\"VALUE6\",\"KEY3\" :\"VALUE7\",\"KEY4\" :\"VALUE8\"}]";

    Pattern pattern = Pattern.compile("\\{(.*?)}");

    Matcher m = pattern.matcher(input);

    while (m.find()) {
        System.out.println(m.group(1));
    }