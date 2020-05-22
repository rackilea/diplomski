@PostConstruct
public void buildUI()
{
    content.add(navigation.getContentPanel()); // Just a SimplePanel with data-field in the Bootstrap html
    RootPanel.get("rootPanel").add(this);
}