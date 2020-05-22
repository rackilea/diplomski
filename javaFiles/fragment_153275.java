package com.preferencetest;

import java.util.prefs.Preferences;

public class PreferenceTest {

  private static final String RUN_MARKER = "RUN_MARKER";

  public static void main(String[] args) {

    // Obtain a Preferences node for this class name.
    final Preferences pref = Preferences.userRoot().node(
        PreferenceTest.class.getName());

    // Read the RUN_MARKER value. For the first start this should be the
    // default value false.
    final boolean previouslyStarted = pref.getBoolean(RUN_MARKER, false); 

    if(!previouslyStarted) {
      // First run: Set the marker to true.
      pref.putBoolean(RUN_MARKER, true);
      System.out.println("First run");
    } else {
      System.out.println("This is not the first run.");
    }
  }
}