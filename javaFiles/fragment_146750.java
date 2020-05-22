public class AccountSettings extends Task {
  private String guid;
  public AccountSettings() {
    super();
    guid = null;
  }

  public void execute() throws BuildException {
    if(guid != null) {
      //Do something with guid
    } else {
      throw new BuildException("guid not defined!");
    }
  }

  public void setGuid(String value) {
    guid = value;
  }
}