@RestController
public class PatientController {

    @GetMapping("/patients")
    List<PatientModel> getPatients() {
        return Arrays.asList(
                new PatientModel("1", "john"),
                new PatientModel("2", "donald")
        );
    }

    static class PatientModel {
        private String id;
        private String name;

        // constructor, getters, setters
    }
}