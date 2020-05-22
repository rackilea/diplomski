public class Year implements Serializable {

   public Date date;
   private SimpleDateFormat format = new SimpleDateFormat( "MM/dd/yyyy" );

   // add this function
   public String execute(){
        return "success";
   }

   public void setDate() throws ParseException {
       int year = request.getParameter( 'inputYear' );
       date = format.parse( "01/01/" + year );
   }

   public String getDate() {
       return format.format( date );
   }

}