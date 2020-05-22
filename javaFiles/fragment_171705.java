final SingleSelectionModel<ContactInfo> selectionModel = new SingleSelectionModel<ContactInfo>(
        ContactDatabase.ContactInfo.KEY_PROVIDER);
    cellList.setSelectionModel(selectionModel);
    selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
      public void onSelectionChange(SelectionChangeEvent event) {
        contactForm.setContact(selectionModel.getSelectedObject());
      }
    });