@Column(...)
private Integer billingMethod;

public BillingMethod getBillingMethod() {
     // add here better error handling (logging additional info
     // to help diagnose array out of bound exceptions).
     return BillingMethod.values()[billingMethod - 1];
}

// add a setter doing a similar thing