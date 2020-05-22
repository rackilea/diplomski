String s = "KEY_1_This_is_a_key, KEY_2_This_is_a_key";

    Matcher m = Pattern.compile("\\b(KEY.+?)\\b").matcher(s);
    while(m.find()){
        System.out.println(m.group());
    }