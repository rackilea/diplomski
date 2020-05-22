Patient example = new Patient();
example.setLastVisitDate(date);
example.setIDQueue(idq);
example.setTicketNumber(tnbr);

matchesDate = session.createCriteria(Patient.class)
                 .add(Example.create(example)).list();
for(Patient patient : matchesDate){
    Transaction t=session.beginTransaction();
    patient.setHourOut(outH);
    session.saveOrUpdate(patient);
    t.commit();
}