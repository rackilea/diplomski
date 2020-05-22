this.fieldsService.areValuesEditable(new AsyncCallback<Boolean>(){

    @Override
    public void onFailure(final Throwable caught){
        Window.alert(caught.getLocalizedMessage());
    }

    @Override
    public void onSuccess(final Boolean result){
        MyEntryPoint.this.areFieldsEnabled = result;
        // Do whatever needs to be done here
        MyEntryPoint.this.fields = new FieldsValuesDiv(entityType, Long.valueOf(entityId), MyEntryPoint.this.areFieldsEnabled);
        wrapper.add(MyEntryPoint.this.fields);
    }
});