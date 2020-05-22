public enum JobTitle implements Textable {
    ARCHITECT("Architect"), TOWN_PLANNER("Town Planner"), URBAN_DESIGNER(
            "Urban Designer"), LANDSCAPE_GARDENER("Landscape Gardener");

    private final String text;

    private JobTitle(String name) {
        this.text = name;
    }

    @Override
    public String getText() {
        return text;
    }
}