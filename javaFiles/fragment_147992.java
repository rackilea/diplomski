public static void main(String[] args) {

        try {
            String dTime = "03:00PM";
            String rTime = "11:00AM";

            System.out.println(convertTo24HoursFormat(dTime));
            System.out.println(convertTo24HoursFormat(rTime));

            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");

            Date dDate = dateFormat.parse(convertTo24HoursFormat(dTime));
            Date rDate = dateFormat.parse(convertTo24HoursFormat(rTime));

            System.out.println("Driver Date=" + dDate);
            System.out.println("Rider Date=" + rDate);

            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTime(dDate);
            calendar1.add(Calendar.HOUR_OF_DAY, 4);

            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(dDate);
            calendar2.add(Calendar.HOUR_OF_DAY, -4);

            System.out.println("Driver Date after adding 4 hours="
                    + calendar1.getTime());
            System.out.println("Driver Date after subtracting 4 hours="
                    + calendar2.getTime());
            System.out.println("Rider Date=" + rDate);

            if (rDate.compareTo(calendar1.getTime()) <= 0
                    && rDate.compareTo(calendar2.getTime()) >= 0) {
                System.out.println("Route acceptable");
            } else {
                System.out.println("Route not acceptable");
            }

        } catch (ParseException ex) {
        }
    }

    private static final DateFormat TWELVE_TF = new SimpleDateFormat("hh:mma");
    private static final DateFormat TWENTY_FOUR_TF = new SimpleDateFormat(
            "HH:mm");

    public static String convertTo24HoursFormat(String twelveHourTime)
            throws ParseException {
        return TWENTY_FOUR_TF.format(TWELVE_TF.parse(twelveHourTime));
    }