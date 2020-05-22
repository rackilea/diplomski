private static class LockScreenHandler extends Handler {
  private WeakReference<BaseActivity> activityRef;

  public LockScreenHandler(BaseActivity activity) {
    activityRef = new WeakReference<>(activity);
  }

  @Override public handleMessage(Message msg) {
    BaseActivity activity = activityRef.get();

    if (activity != null) {
      activity.showLock();
    } // Otherwise the activity got destroyed in the meantime
  }
}