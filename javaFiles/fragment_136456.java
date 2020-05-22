catch(TimeoutException tox) {
  tox.printStackTrace();
  String driverName = tox.getDriverName();
  BuildInfo buildInfo = tox.getBuildInformation();
  ...
}