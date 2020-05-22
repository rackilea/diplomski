class MyPage extends WebPage implements IHeaderContributor {
    public void renderHead(IHeaderResponse response) {
        response.renderJavascriptReference(new ResourceReference(
        MyPage.class, "my.js", getLocale(), getStyle()));
    }
}