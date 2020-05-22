@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = MealDisplayModel.class, name = "MEAL"),
    @JsonSubTypes.Type(value = EntertainmentDisplayModel.class, name = "ENTERTAINMENT")
})
abstract class ActivityDisplayModel {

    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

class MealDisplayModel extends ActivityDisplayModel {

    private boolean complete;

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    @Override
    public String toString() {
        return "MealDisplayModel [complete=" + complete + ", toString()=" + super.toString() + "]";
    }
}

@JsonIgnoreProperties("complete")
class EntertainmentDisplayModel extends ActivityDisplayModel {

    @Override
    public String toString() {
        return "EntertainmentDisplayModel [toString()=" + super.toString() + "]";
    }
}

class Root {

    private ActivityDisplayModel activityDisplayModel;

    public ActivityDisplayModel getActivityDisplayModel() {
        return activityDisplayModel;
    }

    public void setActivityDisplayModel(ActivityDisplayModel activityDisplayModel) {
        this.activityDisplayModel = activityDisplayModel;
    }

    @Override
    public String toString() {
        return activityDisplayModel.toString();
    }
}