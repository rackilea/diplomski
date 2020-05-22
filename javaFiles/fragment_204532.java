public class MyPanel extends Panel {
    private String selected = <what you want>;
    private List<String> projectList <what you want>;
    public MyPanel(String id) {
        super(id);
        add(new DropDownChoice<String>(
           "project", new PropertyModel<String>(this, "selected"), projectsList));
    }
}