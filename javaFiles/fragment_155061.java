public class Workshift {
    private final transient Context context;
    private final Visit visit;
    //for testing
    private String workshift_description;

    public Workshift(Context context,String id) {
        this.workshift_description=id;
        this.context = context;
        this.visit = new Visit(this);

    }
    public String getId() {
        return workshift_description;
    }

    public void setId(String id) {
        this.workshift_description = id;
    }
    public String toString() {
        return "[Workshift element => { WD: "+this.workshift_description+", VD : "+this.visit.getVisit_description()+"}";
    }
}