for(int codePoint : codePoints(string)) {

        char[] chars = Character.toChars(codePoint);
        System.out.println(codePoint + " : " + String.copyValueOf(chars));

    }