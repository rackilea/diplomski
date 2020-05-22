//Don't do this
List<BusinessAccount> accounts=myQuery.getResultList();
int sessionContractorId=accounts.get(0).getId();

//Instead do this
List<BusinessAccount> accounts=myQuery.getResultList();
BusinessAccount account =accounts.get(0); //hopefully an account exists