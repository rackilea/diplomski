public class MyDataPOJO {

   private String title;
   private String format;
   private String date;
   private String name;

   public MyDataPOJO(String title, String format, String date, String name) {
      this.title = title;
      this.format = format;
      this.date = date;
      this.name = name;
   }

   public String getTitle() {return title;}
   public String getFormat() {return formate;}
   // And the rest of the getter methods for date and name
}