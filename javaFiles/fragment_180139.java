public class InterventionsModel {
    private String type;

    @JsonAdapter(LabelsDeserializer.class)
    private List<String> label;

    // Setters and getters
}