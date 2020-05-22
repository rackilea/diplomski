public static String convert16to32(String toConvert){
        for (int i = 0; i < toConvert.length(); ) {
            int codePoint = Character.codePointAt(toConvert, i);
            i += Character.charCount(codePoint);
            //System.out.printf("%x%n", codePoint);
            String utf32 = String.format("0x%x%n", codePoint);
            return utf32;
        }
        return null;
    }