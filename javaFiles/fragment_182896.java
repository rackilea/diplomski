try {

        Date date = formatter.parse(dateInString);
        System.out.println(date);
        System.out.println(formatter.format(date));
        pst.setDate (4, formatter.format(date)); 

    } catch (ParseException e) {
        e.printStackTrace();
    }