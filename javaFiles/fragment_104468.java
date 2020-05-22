public class TransactionNoteDW extends DateAuditableBean {
    //....
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private PatientVisitTransaction patient;
}
public class PatientVisitTransaction extends Bean {
    //....
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
    List<TransactionNoteDW> notes;
}