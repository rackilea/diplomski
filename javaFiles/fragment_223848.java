double max = -Double.MAX_VALUE;
    String smax = null;
    for (String s: args) {
        double d = Double.parseDouble(s);
        if (d > max) {
            smax = s;
            max = d;
        }
    }
    System.out.println(smax);