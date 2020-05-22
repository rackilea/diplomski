@Root(name="scenario")
public class TestScenario {
    @ElementList(inline=true)
    private Dictionary<StepsList> scenario;

    @Attribute(required = false)
    private String name = "";

    public Dictionary<StepsList> getScenario() {
        return scenario;
    }

    @Root(name="cmd")
    public static class StepsList implements Entry {
        @Attribute
        private String name;

        @ElementList(inline=true, entry="return")
        private List<String> steps;

        @Override
        public String getName() {
            return name;
        }

        public List<String> getSteps() {
            return steps;
        }
    }
}