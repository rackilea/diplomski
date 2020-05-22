public class DateIn {

    public static void main(String[] args) {
        String[] dates = {
            "30-08-2011",
            "25.06.2011",
            "15 Juni 2011",
            "01-07-11",
            "19-9-2011",
        };
        DateIn in = new DateIn();
        Locale locale = Locale.US;
        for (String date : dates) {
            try {
                Date d = in.read(date, locale);
                System.out.printf("%s -> %s%n", date,
                    new SimpleDateFormat("yyyy-MM-dd").format(d));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Date read(String date, Locale locale)
            throws IllegalArgumentException {
        final String[] ymdFormatters = { "y", "M", "d" };
        final int[] ymdGetters = { Calendar.YEAR, Calendar.MONTH,
            Calendar.DAY_OF_MONTH };
        String[] tokens = date.split("\\W+");
        final int Y = 0;
        final int M = 1;
        final int D = 2;
        int[] ymdValues = new int[3];
        for (String token : tokens) {
            if (token.matches("\\d+\\pL+")) { // 1st, 2nd, 3rd, 4th, 1e, ...
                token = token.replaceAll("\\pL+", "");
                ymdValues[D] = Integer.parseInt(token);
            } else if (token.matches("\\d+")) {
                int n = Integer.parseInt(token);
                if (n > 31) {
                    ymdValues[Y] = n;
                } else if (n > 12) {
                    ymdValues[D] = n;
                } else {
                    // Locale dependent order.
                    if (ymdValues[M] == 0) {
                        ymdValues[M] = n;
                    } else if (ymdValues[D] == 0) {
                        ymdValues[D] = n;
                    } else if (ymdValues[Y] == 0) {
                        ymdValues[Y] = n;
                    }
                }
            } else if (!token.isEmpty()) {
                for (int md = M; md <= D; ++md) {
                    String fmt = "";
                    for (int i = 0; i < 4; ++i) {
                        fmt += ymdFormatters[md];
                        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
                        sdf.setLenient(true);
                        try {
                            Date dt = sdf.parse(token);
                            Calendar cal = Calendar.getInstance(locale);
                            cal.setTime(dt);
                            int n = cal.get(ymdGetters[md]);
                            if (md == M) {
                                ++n; // To 1-based
                            }
                            ymdValues[md] = n;
                            break;
                        } catch (ParseException e) {
                            //continue;
                        }
                    }
                }
            }
        }
        Calendar calendar = Calendar.getInstance(locale);
        for (int md = Y; md <= D; ++md) {
            int n = ymdValues[md];
            if (n == 0) {
                throw new IllegalArgumentException("Missing "
                    + ymdFormatters[md] + " part in " + date);
            }
            if (md == Y) {
                if (n < 100)
                    n += (calendar.get(Calendar.YEAR) / 100) * 100;
            } else if (md == M) {
                --n; // Calendar's month is 0-based.
            }
            calendar.set(ymdGetters[md], n);
        }
        return calendar.getTime();
    }
}