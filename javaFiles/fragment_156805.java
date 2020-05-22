new OnChangeAjaxBehavior(){
        @Override
        protected void onUpdate(AjaxRequestTarget target) {
            target.appendJavaScript("<call highlight function here>");
        }
    };