public class MyPlugin OServerPluginAbstract implements ODatabaseLifecycleListener {
  @Override
  public void startup() {
    Orient.instance().addDbLifecycleListener(this);
  }

  @Override
  public void onOpen(final ODatabaseInternal db) {
    db.setConflictStrategy(new ORecordConflictStrategy() {
        @Override
        public byte[] onUpdate(OStorage storage, byte iRecordType, ORecordId rid, ORecordVersion iRecordVersion, byte[] iRecordContent, ORecordVersion iDatabaseVersion) {
            <implementation>;
        }

        @Override
        public String getName() {
            return "SOME NAME";
        }
    });
  }

  @Override
  public void onOpen(final ODatabaseInternal db) {
    onOpen(db);
  }
  // BOILERPLATE CODE MISSING
}