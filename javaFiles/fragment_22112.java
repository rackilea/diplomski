import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountSubtractionTest {

    @SuppressWarnings("deprecation")
    public static void main(String args[]){

        List<Person>FinalAmount = new ArrayList<Person>();
        List<Person>Transcation = new ArrayList<Person>();
        @SuppressWarnings("deprecation")
        Date d1 = new Date("01/01/2016");
        @SuppressWarnings("unused")
        Date d2 = new Date("04/01/2016");
        Person p1 = new Person();
        p1.setName("Peter");
        p1.setAccountNo(1234);
        p1.setAccType("Saving");
        p1.setAmount(5000);
        p1.setDate(d1);


        Person p2 = new Person();
        p2.setName("Robin");
        p2.setAccountNo(2222);
        p2.setAccType("Saving");
        p2.setAmount(5000);
        p2.setDate(new Date("02/02/2016"));

        FinalAmount.add(p1);
        FinalAmount.add(p2);

        Person p3 = new Person();
        p3.setName("Peter");
        p3.setAccountNo(1234);
        p3.setAccType("Saving");
        p3.setAmount(1000);
        p3.setDate(d2);

        Person p4 = new Person();
        p4.setName("Robin");
        p4.setAccountNo(2222);
        p4.setAccType("Saving");
        p4.setAmount(2000);
        p4.setDate(new Date("04/02/2016"));

        Transcation.add(p3);
        Transcation.add(p4);

        for(Person p:FinalAmount){
            if(Transcation.contains(p)){
                int index = Transcation.indexOf(p);
                Person person = Transcation.get(index);
                int amount = p.getAmount() - person.getAmount();
                p.setAmount(amount);
                Transcation.remove(index);
            }
        }

        for(int i=0; i<FinalAmount.size(); i++){
            System.out.println(FinalAmount.get(i));
        }






    }

}