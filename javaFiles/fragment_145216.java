public class StrictFloatNumberFormat extends NumberFormat {

  private void validate(in) throws ParseException{
     try {
       new Float(in);
     }
     catch (NumberFormatException nfe) {
       throw new ParseException(nfe.getMessage(), 0);     
  }


  public Number parse(String in) throws ParseException {
    validate(in);
    super.parse(in);
  }
  ..... //any other methods
}