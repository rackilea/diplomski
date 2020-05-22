public class PreferenceForApp {
  Context context;
  SharedPreferences prefs;

  public PreferenceForApp(Context context) {
      this.context = context;
      prefs = context.getSharedPreferences("myAppPrefs", 0);
  }

  public Boolean getIsDeviceValidated() {

      return prefs.getBoolean("Validated", false);
  }

  public void setIsDeviceValidated(Boolean value) {

      SharedPreferences.Editor editor = prefs.edit();
      editor.putBoolean("Validated", value);
      editor.commit();
  }
}