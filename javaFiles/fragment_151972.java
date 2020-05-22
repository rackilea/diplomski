myRadioButton.add(new AjaxEventBehavior("onchange") {
 @Override
 protected void onEvent(AjaxRequestTarget target) {
    myOtherComponent.add(new DefaultFocusBehavior());
        target.addComponent(myForm);
 }
});