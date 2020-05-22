public class YourCustomRevisionListener implements RevisionListener {
  @Override
  public void newRevision(Object revisionEntity) {
    // I am going to assume here you're using a custom revision entity.
    // If you are not, you'll need to cast it to the appropriate class implementation.
    final CustomRevisionEntity revisionEntityImpl = (CustomRevisionEntity) revisionEntity;
    revisionEntityImpl.setTimestamp( resolveValidTimestampValue() );
  }

  private long resolveValidTimestampValue() {
    // implement your logic here.
  }
}