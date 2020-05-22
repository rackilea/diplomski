output = new FileOutputStream("C:\\properties\\worklist.properties");
// For example
int propid = 1;
for(DicomObject dcm : result) {
    String key = "patientName" + new Integer(propid++).toString();
    worklist.setProperty(key,dcm.getString(Tag.PatientName));
}
worklist.store(output, null);