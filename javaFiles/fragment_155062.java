public class Visit {

    private final /* transient  */ Workshift workshift;

    public Visit(Workshift ws) {
        this.workshift = ws;

    }
    public String getVisit_description() {
        return "visit containing  "+ workshift.getId();
    }

}