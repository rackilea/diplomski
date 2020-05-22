final Panel homePanel = new HomePanel("homePanel");
homePanel.setOuputMarkupPlaceholderTag(true);
homePanel.setOuputMarkupId(true);
homePanel.setVisible(false);
add(homePanel);
add(new AjaxSubmitLink("home") {
    protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
        homePanel.setVisible(true);
        // in Wicket 1.4 instead of target.add(Component)
        // target.addComponent(homePanel);
        target.add(homePanel);
    }
});