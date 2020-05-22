AjaxButton save = new AjaxButton("save") {
    public void onSubmit(AjaxRequestTarget target, Form form) {
        // whatever. won't run if any validation fails
    }
    public void onError(AjaxRequestTarget target, Form<?> form) {
        target.addComponent(feedbackPanel);
    }
};