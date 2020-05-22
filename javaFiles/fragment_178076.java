public class poc {
    public static void main(String[] args) {
        GeneralizedTime gt = new GeneralizedTime(Calendar.getInstance());
        String gtADString = gt.toGeneralizedTime(
                GeneralizedTime.Format.YEAR_MONTH_DAY_HOUR_MIN_SEC,
                GeneralizedTime.FractionDelimiter.DOT, 1,
                GeneralizedTime.TimeZoneFormat.Z).replaceFirst("Z", "\\.0Z");
        System.out.println(gtADString);

    }
}