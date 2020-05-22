@OneToMany(fetch=FetchType.EAGER, mappedBy="billInformation"
          , cascade = { CascadeType.PERSIST, CascadeType.REMOVE }
          ,orphanRemoval=true)
Set<BillingItemInformation> setBillingItemInformation;

@OneToMany(fetch=FetchType.EAGER, mappedBy="billInformation"
         , cascade ={ CascadeType.PERSIST, CascadeType.REMOVE }
         ,orphanRemoval=true)
Set<BillingTaxInformation> setBillingTaxInformation;