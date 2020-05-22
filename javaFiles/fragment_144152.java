ContinuityOfCareDocument ccd = ConsolFactory.eINSTANCE.createContinuityOfCareDocument().init();
Patient patient = CDAFactory.eINSTANCE.createPatient();
PN pn = DatatypesFactory.eINSTANCE.createPN();
pn.addText("Plain Old Name Here");
patient.getNames().add(pn);
ccd.addPatient(patient);
CDAUtil.save(ccd, System.out);