import android.os.Build;

public class IDE {
  private static IDE instance = null;
  protected boolean designMode = false;

  private IDE() {
    designMode = Build.DEVICE.startsWith("generic");
  }

  public static IDE getInstance() {
    if (instance == null)
      instance = new IDE();
    return instance;
  }

  public static boolean DesignMode() {
    return getInstance().designMode;
  }
}