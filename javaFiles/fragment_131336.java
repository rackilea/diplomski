public class CourseCell extends ListCell<Course> {

    @Override
    protected void updateItem(Course item, boolean empty) {
        super.updateItem(item, empty);
        if (item != null) {
            setText(item.getTitle());
        } else {
            setText(null);
        }
    }
}