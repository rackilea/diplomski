public static Patient getPatient(List<Patient> patients, String wantedName){
    Patient wantedPatient = null;
        for(Patient patient: patients){
            if(patient.getName().equals(wantedName)){
                wantedPatient = patient;
                break;
            }
        }
    return patient;
}