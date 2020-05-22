public class SlammedNavigatorActivity extends DroidGap {
  private PowerManager.WakeLock wLock;


  public void onCreate(Bundle savedInstanceState) {
    // ...
    wLock = pm.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK, "SN Wake Lock");
    // ...
  }
}