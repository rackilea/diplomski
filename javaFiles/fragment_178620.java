private ArrayList<IWidget> widgets;

@PostConstruct
public void postConstruct(Composite parent, WidgetList widgetList) {
    widgets = widgetList.getWidgets();
}