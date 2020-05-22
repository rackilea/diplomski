public class Storage2 {

  public String deviceRootDir;
  public String sdRootDir;

  private final Context context;

  public Storage2(Context context) {
      this.context = context;
  }

  public Storage2() {
    //...
    File[] f = context.getExternalFilesDirs(null);
    //...
    this.deviceRootDir = context.getExternalFilesDir(null).getPath().replaceAll(replacePattern, "$1");
    }
  }
}