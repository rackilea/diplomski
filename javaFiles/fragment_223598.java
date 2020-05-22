final Panel emptyPanel = new EmptyPanel("homePanel");
emptyPanel.setOuputMarkupPlaceholderTag(true);
emptyPanel.setOuputMarkupId(true);
add(emptyPanel);
add(new AjaxSubmitLink("home") {
    protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
        Panel homePanel = new HomePanel("homePanel");
        homePanel.setOuputMarkupPlaceholderTag(true);
        homePanel.setOuputMarkupId(true);
        // if your Page class is MyPage.class
        MyPage.this.addOrReplace(homePanel);
        // in Wicket 1.4 instead of target.add(Component)
        // target.addComponent(homePanel);
        target.add(homePanel);
    }
});