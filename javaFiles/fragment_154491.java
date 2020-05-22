public abstract class BasePage extends WebPage {

public BasePage() {
    add(HeaderContributor.forJavaScript("foo-base.js"));
}

}