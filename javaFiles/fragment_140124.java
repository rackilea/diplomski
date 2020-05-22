public class LoanAccount {
    private String id;
    private Integer numberOfInstallments;

// add other properties

public String getId() {
    return id;
}

public LoanAccount setId(String id) {
    this.id = id;
    return this;
}

public Integer getNumberOfInstallments() {
    return numberOfInstallments;
}

public LoanAccount setNumberOfInstallments(Integer numberOfInstallments) {
    this.numberOfInstallments = numberOfInstallments;
    return this;
}