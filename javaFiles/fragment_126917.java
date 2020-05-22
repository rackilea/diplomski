StringBuilder sb = new StringBuilder(s);

    int i = 0;
    while (i + 10 < sb.length() && 
            (i = Math.max( sb.indexOf(" ", i), sb.lastIndexOf(" ", i + 10))) != -1) {
        sb.replace(i, i + 1, "\n");
    }

    System.out.println(sb.toString());