add(new AjaxFallbackLink<String>("change-password") {
    @Override 
    public void onClick(AjaxRequestTarget target) {
        target.appendJavascript("$('input:password').dPassword();")
        window.show(target);
    }
});