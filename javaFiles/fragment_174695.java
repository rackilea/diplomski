public class Email {
    int id;
    String firstProperty;
    String secondProperty;
    String thirdProperty;
    String fourthProperty;
    Date date;

    public Email(int id, String firstProperty, String secondProperty, String thirdProperty, String fourthProperty, Date date) {
         this.id = id;
         this.firstProperty = firstProperty;
         this.secondProperty = secondProperty;
         this.thirdProperty = thirdProperty;
         this.fourthProperty = fourthProperty;
         this.date = date;
    }

    @Override
    public String toString(){
        return ("ID: " + this.id + ", Name: " + this.firstProperty);
    }
}