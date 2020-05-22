public class HomePage extends BasePage {

private static final long serialVersionUID = 1L;

private final HeaderContributor contrib = new HeaderContributor(
        new IHeaderContributor() {
    public void renderHead(IHeaderResponse response) {
        response.renderJavascriptReference("foo-first.js");
    }
});

public HomePage(final PageParameters parameters) {
    add(new Label("message", "If you see this message ..."));
    add(contrib);
}

@Override
protected List getBehaviors(Class type) {
    List behaviors = super.getBehaviors(type);
    ArrayList sortedBehaviors = new ArrayList(behaviors);
    boolean moveToTop = true;
    if (moveToTop) {
        if (!sortedBehaviors.remove(contrib)) {
            throw new IllegalStateException();
        }
        sortedBehaviors.add(0, contrib);
    }
    return sortedBehaviors;
}
}