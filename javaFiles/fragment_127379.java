public class ShiftHour {
    public static final int MONDAY = 0, TUESDAY = 1, WEDNESDAY = 2, THURSDAY = 3, FRIDAY = 4, SATURDAY = 5, SUNDAY = 6;
    private static final String[] names = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    public static class OperatingHours {
        int[] hours = new int[7];
        public void addShift(final int start, final int end, final int... days) {
            for (int i = start; i <= end; i++) {
                for (final int w : days)
                    hours[w] |= (1 << i);
        }

        public void printHours() {
            final StringBuilder sb = new StringBuilder();
            String prevDay = getDay(hours[0]);
            String startDay = names[0];
            String endDay = names[0];
            for (int i = 1; i < 7; i++) {
                final String day = getDay(hours[i]);
                if (day.equals(prevDay)) endDay = names[i];
                else {
                    appendDay(sb, startDay, endDay, prevDay);
                    prevDay = day;
                    startDay = endDay = names[i];
                }
            }
            appendDay(sb, startDay, endDay, prevDay);
            System.out.println(sb.toString());
        }

        String getDay(final int m) {
            final StringBuilder sb = new StringBuilder();
            int startHour = -1;
            int endHour = -1;
            for (int i = 0; i <= 24; i++) {
                if (((1 << i) & m) > 0) {
                    if (startHour == -1) startHour = i;
                    endHour = i;
                } else if (startHour >= 0) {
                    sb.append("\t" + formatHour(startHour) + " to " + formatHour(endHour) + "\n");
                    startHour = endHour = -1;
                }
            }
            if (startHour >= 0) sb.append("\t" + formatHour(startHour) + " to " + formatHour(endHour) + "\n");
            return sb.toString();
        }

        void appendDay(final StringBuilder sb, final String startDay, final String endDay, final String prevDay) {
            sb.append(startDay + (startDay.equals(endDay) ? "" : ("-" + endDay)) + "\n" + (prevDay.equals("") ? "\tClosed\n" : prevDay));
        }

        String formatHour(final int h) {
            if (h == 0) return "12AM";
            if (h < 12) return h + "AM";
            if (h == 12) return "12PM";
            if (h < 24) return (h - 12) + "PM";
            return "12AM"; // 24 hours is midnight again
        }
    };

    public static void main(final String[] args) {
        final OperatingHours hours = new OperatingHours();
        hours.addShift(9, 14, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY);
        hours.addShift(16, 21, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY);
        hours.addShift(12, 17, FRIDAY);
        hours.addShift(14, 19, SATURDAY);

        hours.printHours();
    }
}