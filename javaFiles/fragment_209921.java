static boolean isCommonSubstring (String one, String two) {
        if (one.length() < two.length()){
            String tmp = one;
            one = two;
            two = tmp;
        }
        MAIN :
        for (int i = 0 ; i <= one.length()-two.length() ; i++){
            for (int j = 0 ; j < two.length() ; j++){
                if ((one.charAt(i+j) != two.charAt(j))) continue MAIN;
            }
            return true;
        }
        return false;
    }