double[] v = { 221, 22.1, 22.11 };
        Locale.setDefault(Locale.GERMANY);

        for (double val : v) {
            String str = String.format("%.2f", val);
            str = str.replaceAll("(.*?)0*$", "$1").replaceAll("(.*?)\\,$", "$1");

            System.out.println(str);
        }