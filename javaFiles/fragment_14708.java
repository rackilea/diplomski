public class HeaderForm extends Composite
{
 public HeaderForm()
 {
    VerticalPanel verticalPanel = new VerticalPanel();
    Label label = new Label("Some text here which should be visible");
    verticalPanel.add(label);
    initWidget(verticalPanel);
 }
}