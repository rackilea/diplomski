public static String max(ArrayList<String> list) {
        String a = "";
        for (String string : list) {
            if (string.length() >= a.length()) {
                a = string;
                for (String si : list) {
                    System.out.println(si);
                }
            }

        }
        return a;
    }