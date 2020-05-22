// Old style (Object oriented)
class PatientInfo{
    String religion;
    String address;
}
PatientInfo patientInfo = new PatientInfo();
patientInfo.setReligion("myReligionName"); 
patientInfo.setAddress("address of the patient"); 

// New Style, key/value primitive pairs (very not object oriented)
Pair<String,String> religionInfo = new Pair<String,String>("religion","myReligionName");
Pair<String,String> addressInfo = new Pair<String,String>("address","address of the patient");