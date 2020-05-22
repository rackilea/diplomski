String s = "a?b?gf#sad";
    final StringTokenizer stringTokenizer = new StringTokenizer(s, "#?", true);
    String[] a = new String[stringTokenizer.countTokens()];
    int i = 0;
    while(stringTokenizer.hasMoreTokens())
        a[i++] = stringTokenizer.nextToken();
    System.out.println(Arrays.toString(a));