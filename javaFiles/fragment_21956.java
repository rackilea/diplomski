public class Main {
    public static void main(String[] args) {
        BoundedCounter minutes = new BoundedCounter(59);
        BoundedCounter hours = new BoundedCounter(23);

        int i = 0;
        while (i < 121) {
            System.out.println(hours + ":" + minutes);

            minutes.next();                 // counting minutes
            if (minutes.getValue() == 0) {  // when minutes==0, count hours
                hours.next();               // counting hours
                i++;
            }
        }
    }
}