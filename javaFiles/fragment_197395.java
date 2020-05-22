firstNameColumn.setFieldUpdater(new FieldUpdater<ContactInfo, String>() {
  @Override
  public void update(int index, ContactInfo object, String value) {
    getPresenter().onUpdate(info,value);
  }
});