package my.library;

import com.google.gwt.core.client.GWT;

public class EnvironmentFlags {
  public static final boolean IS_GWT      = true;
  public static final boolean IS_DEV_MODE = !GWT.isProdMode();
}