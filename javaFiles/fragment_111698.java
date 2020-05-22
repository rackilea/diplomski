int codePointCopyright = Integer.parseInt("00A9", 16);

    System.out.println(Integer.toHexString(codePointCopyright));
    System.out.println(Character.isValidCodePoint(codePointCopyright));

    char[] toChars = Character.toChars(codePointCopyright);
    System.out.println(toChars);

    System.out.println();

    int codePointAsian = Integer.parseInt("20011", 16);

    System.out.println(Integer.toHexString(codePointAsian));
    System.out.println(Character.isValidCodePoint(codePointAsian));

    char[] toCharsAsian = Character.toChars(codePointAsian);
    System.out.println(toCharsAsian);