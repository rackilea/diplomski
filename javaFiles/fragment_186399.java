@SpringUI
@Theme("dashboard")
public class UI extends UI {

@Autowired
private SpringViewProvider viewProvider;

private final HorizontalLayout root = new HorizontalLayout();
private ComponentContainer content;
private Navigator navigator;

@Override
protected void init(VaadinRequest request) {

    setLocale(Locale.US);

    Responsive.makeResponsive(this);
    addStyleName(ValoTheme.UI_WITH_MENU);

    root.setSizeFull();
    root.addStyleName("mainview");
    setContent(root);

    root.addComponent(new DashboardMenu());

    content = new CssLayout();
    content.addStyleName("view-content");
    content.setSizeFull();
    root.addComponent(content);
    root.setExpandRatio(content, 1.0f);

    navigator = new Navigator(this, content);
    navigator.addProvider(viewProvider);
    navigator.navigateTo(DashboardView.NAME);
}
}