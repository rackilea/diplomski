public class SomeObject{
    public String creationDate;
    public SomeObject(){
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date today = Calendar.getInstance().getTime();        
        String creationDate = df.format(today);
    }
}