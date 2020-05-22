public static String halfOfString(String message,int start ){
            StringBuilder halfString = new StringBuilder();
            for (int k=start;k<message.length();k+=2){
                char achar = message.charAt(k);
                halfString.append(achar);
            }
            return halfString.toString();
        }