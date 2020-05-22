NumberFormat fmt = NumberFormat.getInstance(Locale.GERMAN);
        try {
            BigDecimal bd = new BigDecimal(fmt.parse("2.000,15").toString());
            System.out.println(bd.toString()); // output: 2000.15
        } catch (ParseException e) {
            //ex handling
        }