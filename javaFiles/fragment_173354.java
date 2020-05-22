public static String getAlphaNumbericRandom(int length) {
         String chars = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

            int numberOfCodes = 0;//controls the length of alpha numberic string
            String code = "";
            while (numberOfCodes < length) {
                char c = chars.charAt((int) (Math.random() * chars.length()));
                code += c;
                numberOfCodes++;
            }
            return code;
        }