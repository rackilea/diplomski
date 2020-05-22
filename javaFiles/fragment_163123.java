String a = " 7465737420202020203f7465737420202020202020202020203f7465737420202020202020202020203fd3f7d3f7d3f77f078840ffffffffffff";
    a = a.trim();
    StringBuffer result = new StringBuffer();

    for (int i = 0; i < a.length(); i+=2) {
        String sub = a.substring(i, i+2);
        int b = Integer.parseInt(sub, 16);
        result.append((char)b);
    }

    System.out.println(result);