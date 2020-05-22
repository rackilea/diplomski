public boolean equals(Object o) {
 // If the object is compared with itself then return true
  if (o == this) 
    return true;

/* Check if o is an instance of PatientRecordEntity or not
 "null instanceof [type]" also returns false */
  if (!(o instanceof PatientRecordEntity)) 
     return false;


// typecast o to Complex so that we can compare data members
PatientRecordEntity c = (PatientRecordEntity) o;


 boolean isEqual = true; //I assume these are equal
// Compare the data members and return accordingly
if (Double.compare(pid, c.pid) != 0) {
  System.out.println("PID not Equal");
  isEqual = false;
}
if (!patient_db_ID.equals(c.patient_db_ID)) {
  System.out.println("Patient ID not Equal");
  isEqual = false;
} 
if (!bed_number.equals(c.bed_number)) {
  System.out.println("Bed number not Equal");
  isEqual = false;
} 
if (!patient_race.equals(c.patient_race)) {
  System.out.println("Patient Race not Equal");
  isEqual = false;
}  
if (!real_bed_number.equals(c.real_bed_number)) {
  System.out.println("Real Bed number not Equal");
  isEqual = false;
} 
if (!register_date.equals(c.register_date)) {
  System.out.println("Registger bed not Equal");
  isEqual = false;
} 
if (!register_time.equals(c.register_time)) {
  System.out.println("Register time not Equal");
  isEqual = false;
} 
if (Double.compare(patient_age,c.patient_age) != 0) {
  System.out.println("Patient age not Equal");
  isEqual = false;
} 
if (Double.compare(patient_gender,c.patient_gender) != 0) {
  System.out.println("Patient gender not Equal");
  isEqual = false;
} 
if (!patient_IC.equals(c.patient_IC)) {
  System.out.println("Patient IC not Equal");
  isEqual = false;
} 
if (Double.compare(no_wounds,c.no_wounds) != 0) {
  System.out.println("no wounds not Equal");
  isEqual = false;
} 

return isEqual; }