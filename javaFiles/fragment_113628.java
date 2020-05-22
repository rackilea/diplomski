public class DIRECTORY {
       private Map<String, SCHOOL> schools = new HashMap<String, SCHOOL>();


        public void setSchools(Map<String, SCHOOL> schoolsMap) {
        this.schools =  schoolsMap;
        }

     public Map<String, SCHOOL> getSchools() {return this.schools;}


     public void addSchool(String schoolId, String schoolName) {
         SCHOOL school = new SCHOOL();
         school.setSchoolId(schoolId);
         school.setSchoolName(schoolName);
         schools.put(schoolId,school);

    }

   public SCHOOL getSchoolById(String schoolId) {
         schools.get(schoolId);
    }

   }