SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
        Date date = null;
        try {
            date = formatter.parse("Sun May 20 18:07:13 EEST 2018");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date);