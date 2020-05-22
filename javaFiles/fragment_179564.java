public static void main(String[] args) {

        SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            Date date = dateFormat.parse("20/Jan/2015 15:19:51");
            System.out.println(date);
        } catch (ParseException e) {

            e.printStackTrace();
        }


  }