public class MarkStructureItem {

    final SimpleIntegerProperty marks;
    final int id;

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null
                  && obj.getClass() == this.getClass()
                  && this.id == ((MarkStructureItem) obj).id; // primitive type can be compared using ==
                  // && this.getId().equals(((MarkStructureItem) obj).getId()); // alternative for non-primitive types
    }

    public MarkStructureItem(int finishPosition, Integer marks) {
        this.marks = new SimpleIntegerProperty(marks);
        this.id = finishPosition;
    }

    public int getId() {
        return id;
    }

    public IntegerProperty marksProperty() {
        return marks;
    }