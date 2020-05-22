for (int i = 0; i < toConvert.length(); ) {
        int codePoint = Character.codePointAt(toConvert, i);
        i += Character.charCount(codePoint);
        System.out.printf("[%d] cp: %x%n", i, codePoint);
    }
    for (int i = 0; i < toConvert.length(); ++i) {
        char ch = toConvert.charAt(i);
        System.out.printf("[%d] c: %x%n", i, (int)ch);
    }