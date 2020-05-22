private WebMarkupContainer tr() {
    WebMarkupContainer wmc = new WebMarkupContainer("tr");
    wmc.add(new AjaxEventBehavior("click") {

        @Override
        protected void onEvent(AjaxRequestTarget target) {
            //go to the same place as the XXXDetailLink
        }
    });
    return wmc;
}