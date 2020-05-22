public class Payment implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer customerNumber;
    private String checkNumber;
    private Date paymentDate;
    private Double amount;
        // setters and getters

        @Override
    public String toString() {
        return customerNumber + "|"+ checkNumber + "|" + paymentDate + "|"+ amount ;
    }
}