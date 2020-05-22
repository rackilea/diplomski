import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class ApplicantStructureTest {

    public static void main(String[] args) {
        List<ApplicantModel> applicants = new LinkedList<>();
        applicants.add(new ApplicantModel("id1", 30, "name1"));
        applicants.add(new ApplicantModel("id2", 30, "name2"));
        applicants.add(new ApplicantModel("id5", 31, "name3"));
        applicants.add(new ApplicantModel("id6", 31, "name4"));

        // here is your for loop
        TreeMap<Integer, TreeMap<String, String>> structured = new TreeMap<Integer, TreeMap<String, String>>();
        for (int i = 0; i <= applicants.size() - 1; i++) {
            ApplicantModel applicant = applicants.get(i);
            Integer age = applicant.getAge();
            TreeMap<String, String> ageMap = structured.get(age);
            if (ageMap == null) {
                ageMap = new TreeMap<String, String>();
                structured.put(age, ageMap);
            }
            ageMap.put(applicant.getId(), applicant.getName());
        }


        System.out.println(structured);
    }

    public static class ApplicantModel {
        private Integer age;
        private String id;
        private String name;

        public ApplicantModel(String id, Integer age, String name) {
            this.id = id;
            this.age = age;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public String getId() {
            return id;
        }

    }

}