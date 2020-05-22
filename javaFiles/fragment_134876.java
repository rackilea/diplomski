boolean rollback = false;
List<File> changes = new ArrayList<File>();

for(int i = 0; i < users.length() && !rollback; i++) {
  User user = users.get(i);
  File file = new File("Directory");
  if(!file.exist()){
    try {
      file.mkdir();
      changes.add(file);
    } catch (Throwable t) {
      rollback = true;
  }
}

if (rollback) {
  // report failure?
  try {
    for(File file : changes) {
      file.rmdir();
    }
  } catch (Throwable t) {
      //So something smart here.
  }
}