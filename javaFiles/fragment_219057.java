public class ParentIcon implements Icon {
    private List<Icon> children = new ArrayList<Icon>();
    public void paint() {
        for (Icon child : children) {
            child.paint();
        }
    }
}