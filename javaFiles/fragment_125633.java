char[] obcChars = {'#', ';', '"', '¬', '¦', '+', ';'
            , '/', '.', '^', '&', '$', '*'
            , '[', '@', '-', '~', ':'};
    StringBuilder sb = new StringBuilder();
    sb.append(obcChars[0]);
    for (int i=1; i<obcChars.length; i++) {
        sb.append("|\\");
        sb.append(obcChars[i]);
    }
    // sb now contains the regex #|\;|\"|\¬|\¦|\+|\;|\/|\.|\^|\&|\$|\*|\[|\@|\-|\~|\: