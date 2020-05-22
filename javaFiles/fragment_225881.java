public static String meshStrings (String string1, String string2) {
        StringBuffer buff = new StringBuffer();
        int max = Math.max(string1.length(), string2.length());
        for(int i = 0; i < max; i++) {
            if(i < string1.length()) {
                buff.append(string1.charAt(i));
            }
            if(i < string2.length()) {
                buff.append(string2.charAt(i));
            }
        }
        return buff.toString();
    }