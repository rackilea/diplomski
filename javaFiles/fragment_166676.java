import lombok.Data;

@Data
public class Student_payment_details {
    int pay;
    String date;
    String phcounter;
}

import lombok.Data;

@Data
public class Student {
    private int id;
    private String name;
    private int age;
    private String registrationNumber;
    private Student_payment_details payment_detailsList; //getter and setter
}