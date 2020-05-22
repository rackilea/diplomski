PatientCSV foundPatient = null;
for (Object patObj : patList) {

  PatientCSV pat = (PatientCSV) patObj;
  if(((PatientCSV) patObj).getPatID().equals(sID)){
      foundPatient = pat;
  }
}

if (foundPatient == null) {
    foundPatient = new PatientCSV();
    foundPatient.setPatID(sID);
    foundPatient.setPseudoID(pseudoID);
    patList.add(foundPatient);
    /*Find a way to import it to the CSV*/
    bc.write(foundPatient);
    writer.close();
}

return foundPatient.getPseudoID();