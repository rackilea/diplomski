public static void main(String[] args) throws ParseException {

    DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Date lastDec2010 = sdf.parse("31/12/2010");

    Calendar calUs = Calendar.getInstance(Locale.US);       
    calUs.setTime(lastDec2010);

    Calendar calDe = Calendar.getInstance(Locale.GERMAN);       
    calDe.setTime(lastDec2010);

    System.out.println( "us: " + calUs.get( Calendar.WEEK_OF_YEAR ) ); 
    System.out.println( "de: " + calDe.get( Calendar.WEEK_OF_YEAR ) );
}