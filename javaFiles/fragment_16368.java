public static String formatArray(int[] tallrekke){
        String result = "";
        for (int i = 0; ; i++) {
            result +=tallrekke[i];
            if (i == tallrekke.length-1)
                return result;
            result+= i==tallrekke.length-2?" og ":", ";
        }
    }