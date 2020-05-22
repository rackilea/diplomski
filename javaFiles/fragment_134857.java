Date dateInput;
String str = "11:22";
DateFormat inputFormat = new SimpleDateFormat("mm:ss");
            try {
               dateInput = inputFormat.parse(str);
            } catch (ParseException e) {
                e.printStackTrace();
            }