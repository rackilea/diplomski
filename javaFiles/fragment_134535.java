@Entity
public class Payment {
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="myColumn")
    private Person receiverOfPayment;
}

@Entity
public class Person {
    @OneToOne(mappedBy="receiverOfPayment")
    private Payment payment;
}