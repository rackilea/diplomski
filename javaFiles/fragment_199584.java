public abstract class Subject extends BaseChildParentModel {
    public List<Subject> ChildSubjects;

    @Override
    public <E extends BaseModel> List<E> getChildren() {
        return (List<E>) ChildSubjects;
    }

    @Override
    public <E extends BaseModel> List<E> createChildList() {
        ChildSubjects = new ArrayList<>();
        return (List<E>) ChildSubjects;
    }
}