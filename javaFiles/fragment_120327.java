save = new Button("Save", new ClickListener() {
    @Override
    public void buttonClick(ClickEvent event) {
        try {
            editor.commit();

            // no CommitException thrown until now, so go ahead and tell the presenter:
            presenter.doSave(entity);
        } catch (CommitException e) {
            // validation failed -> don't tell the presenter
            Notification.show("Form invalid");
        }
    }
});