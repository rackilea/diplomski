public class WidgetContainer {

    private ArrayList<IWidget> widgets;

    public WidgetContainer() {
        widgets = new ArrayList<>();
    }

    public void add(IWidget widget) {
        widgets.add(widget);
    }

    public void remove(IWidget widget) {
        widgets.remove(widget);
    }

    public ArrayList<IWidget> getWidgets() {
        return widgets;
    }
}