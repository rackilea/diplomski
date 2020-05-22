String s = "Generalization";
    char[] sChars = s.toCharArray();
    for (int i = 0; i < sChars.length; i++) {
        if (sChars[i] == 'z') {
            sChars[i] = 'y';
        }
    }
    s = String.copyValueOf(sChars);
    System.out.println(s);