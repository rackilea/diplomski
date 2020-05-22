public void deletePatient(int patientId) {
    Session currentSession = sessionFactory.getCurrentSession();

    // get patient with primary key
    Patient patient = currentSession.get(Patient.class, patientId);  
    Set<OutboundMessage> messages = patient.getOutboundMessages();

    //set patient id null
    for(OutboundMessage message : messages) {
        message.setPatient(null);
    }

    //delete the patient
    currentSession.remove(patient);
}