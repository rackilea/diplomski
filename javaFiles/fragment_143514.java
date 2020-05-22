realm.executeTransaction(new Realm.Transaction() {
  @Override
  public void execute(Realm realm) {
    if (parent.getChild() == null) { // Only create a child if it is missing.
      Child child = realm.createObject(Child.class);
      parent.setChild(child);
    }
    parent.getChild().setSomeValue(value);
    parent.setNotificationConstants(notificationConstants);
  }
});