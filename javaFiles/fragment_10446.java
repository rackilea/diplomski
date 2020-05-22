public class SearchTerm {

    private boolean selected;
    private String text;

    public SearchTerm(boolean selected, String text) {
        this.selected = selected;
        this.text = text;
    }

    public boolean isSelected() {
        return selected;
    }

    public String getText() {
        return text;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

}