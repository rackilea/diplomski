public Map<String, PatientMapObject> getPatients(String sendingApplication,String sendingFacility) {
    // TODO Auto-generated method stub
    Map<String, PatientMapObject> patientMap = null;
    List<PatientInfo> patientList = null;
    patientMap = new HashMap<String, PatientMapObject>();
    patientList = new ArrayList<PatientInfo>();
    try {

        PatientInfoDAO patientInfoDAO = new PatientInfoDAOImpl();
        ItemCollection<QueryOutcome> items = patientInfoDAO.getPatients(sendingApplication, sendingFacility);

       for(Item item : items){
            PatientInfo patient = new PatientInfo();

            patient.setAdministrativeSex("Male");

            patientList.add(patient);
        }

        String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        PatientMapObject pmo = new PatientMapObject();
        pmo.setPatientList(patientList);
        pmo.setPDate(date);

        patientMap.put("PATIENTLIST", pmo);
        return patientMap;
    }catch(Exception ase){

        throw new RuntimeException("internalServerError");
    }
}

class PatientMapObject{


    private List<PatientInfo> patientList;
    private String pdate;

    public void setPDate(String pdate) {
        this.pdate = pdate; 
    }

    public void setPatientList(List<PatientInfo> patientList) {
        this.patientList = patientList;
    }

    //getters 
}