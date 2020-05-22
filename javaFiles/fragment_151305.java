class DataSourceAttachable implements Attachable {
  String name;
  DataSource dataSource;  // Initialize in ctor.

  void attach(Helper helper) {
    helper.addAttachment(name, dataSource);
  }
}

// etc, for other types