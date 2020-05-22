try {
        SimpleDateFormat format1 = new SimpleDateFormat("MMM dd, yyyy");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
        String stringDate = "Dec 13, 2013";

        Date date = format1.parse(stringDate);

        System.out.println(format2.format(date));
    } catch (ParseException exp) {
        // Take appropriate action
    }