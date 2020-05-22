public void addIdentity(PatientIdentity patientIdentity) {
   if (urs=null) {
      urs = new ArrayList<PatientIdentity>();
   }
   urs.add(patientIdentity);
   patientIdentity.setPatient(this);
}

    myIdentity = new PatientIdentity();
    myIdentity.setUr(ur);
    myIdentity.setCreated(new Date());
    myIdentity.setPrimary(true);
   // you don't need this code any longer since you are cascading your persist. 
   //patientIdentityService.create(myIdentity);

    Patient myPatient = new Patient();
    myPatient.setDateOfBirth(dateOfBirth);
    myPatient.setDateOfDeath(dateOfDeath);
    myPatient.setLastUpdated(new Date());

    myPatient.addIdentity(myIdentity);

    // this will cascade the persist
    repo.saveAndFlush(myPatient);