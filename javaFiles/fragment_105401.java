queryTextField.add(new AjaxEventBehavior("onKeyUp") {
        @Override
        protected void onEvent(AjaxRequestTarget target) {
            addressTextField.setEnabled(false);
            target.add(addressTextField);        
        }
    }
);