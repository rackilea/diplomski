AjaxEventBehavior behavior = new AjaxEventBehavior("keyup") {

    @Override
    protected void onEvent(AjaxRequestTarget target) {
        System.out.println("Hello world!");
    }
    @Override
    protected void updateAjaxAttributes(AjaxRequestAttributes attributes)
        super.updateAjaxAttributes(attributes);
        attributes.setThrottlingSettings(
            new ThrottlingSettings(id, Duration.ONE_SECOND, true)
        );
    }
};