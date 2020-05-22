public class tempClass {

    static final String s = "2012-01-01T08:44:36+01:00".intern();
    static String formattedDate = null;
    static final int loop = 5 * 1000;
    static final String[] patterns = new String[]{"yyyy-MM-dd'T'HH:mm:ss+01:00".intern()};

    public static void main(String[] args) throws ParseException, InterruptedException {
        testSimpleWay();
        testRegXp();
        testSimpleDateFormat();
        testFastDateFormat();
    }

   private static void testRegXp() {
        Pattern pattern = Pattern.compile("(.+)(T)(.+)([+-])");
        Matcher matcher;

        final long timeStamp = System.currentTimeMillis();            
        for (int i = 0; i < loop; i++) {
            matcher = pattern.matcher(s);
            if (matcher.find()) {
                formattedDate = matcher.group(1) + ' ' + matcher.group(3);
            } else {
                System.err.println("Bad date: " + s);
            }
        }
        System.out.println("Duration of RegXP: " + (System.currentTimeMillis() - timeStamp) + " ms.");
    }

    private static void testSimpleWay() {
        long timeStamp = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            formattedDate = s.substring(0, 10) + ' ' + s.substring(11, 19);
        }
        System.out.println("Duration of Simple way: " + (System.currentTimeMillis() - timeStamp) + " ms.");
    }

    private static void testSimpleDateFormat() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        final long timeStamp = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            try {
                formattedDate = simpleDateFormat.format((Date) DateUtils.parseDate(s, patterns));
            } catch (ParseException ex) {
                System.err.println("Bad date: " + s);
            }
        }
        System.out.println("Duration of SimpleDateFormat: " + (System.currentTimeMillis() - timeStamp) + " ms.");
    }

    private static void testFastDateFormat() {
        FastDateFormat fastDateFormat = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");

        final long timeStamp = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            try {
                formattedDate = fastDateFormat.format((Date) DateUtils.parseDate(s, patterns));
            } catch (ParseException e) {
                System.err.println("Bad date: " + s);
            }
        }
        System.out.println("Duration of FastDateFormat: " + (System.currentTimeMillis() - timeStamp) + " ms.");
    }