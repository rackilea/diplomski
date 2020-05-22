AjaxButton cancel = new AjaxButton("cancel") {
    public void onSubmit(AjaxRequestTarget target, Form form){
        setResponsePage(new LecturerPage());
    }
};
cancel.setDefaultFormProcessing(false);