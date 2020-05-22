public void load() {
  Properties props = new Properties();
  FileInputStream fis = new FileInputStream("....custom.properties")
  props.load(fis);
  Global.DEBUGFLAG= Boolean.valueOf(props.get("enabledebug"));
}