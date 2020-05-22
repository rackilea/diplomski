INPUT_METHOD_MANAGER__SERVED_VIEW(SDK_INT >= ICE_CREAM_SANDWICH_MR1 && SDK_INT <= N_MR1) {
    @Override void add(ExcludedRefs.Builder excluded) {
      String reason = "When we detach a view that receives keyboard input, the InputMethodManager"
          + " leaks a reference to it until a new view asks for keyboard input."
          + " Tracked here: https://code.google.com/p/android/issues/detail?id=171190"
          + " Hack: https://gist.github.com/pyricau/4df64341cc978a7de414";
      excluded.instanceField("android.view.inputmethod.InputMethodManager", "mNextServedView")
          .reason(reason);
      excluded.instanceField("android.view.inputmethod.InputMethodManager", "mServedView")
          .reason(reason);
      excluded.instanceField("android.view.inputmethod.InputMethodManager",
          "mServedInputConnection").reason(reason);
    }
  },

  INPUT_METHOD_MANAGER__ROOT_VIEW(SDK_INT >= ICE_CREAM_SANDWICH_MR1 && SDK_INT <= M) {
    @Override void add(ExcludedRefs.Builder excluded) {
      excluded.instanceField("android.view.inputmethod.InputMethodManager", "mCurRootView")
          .reason("The singleton InputMethodManager is holding a reference to mCurRootView long"
              + " after the activity has been destroyed."
              + " Observed on ICS MR1: https://github.com/square/leakcanary/issues/1"
              + "#issuecomment-100579429"
              + " Hack: https://gist.github.com/pyricau/4df64341cc978a7de414");
    }
  },