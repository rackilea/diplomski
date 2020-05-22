for (int j = wordEntered.length(); j > 0; j--) {
    for (int i = 0; i < j; i++) {
        if (i < j - 1)
            System.out.print(wordEntered.charAt(i) + "-");
        else
            System.out.println(wordEntered.charAt(i));
    }
    System.out.print(StringUtils.repeat(" ", wordEntered.length() - j + 1));
}