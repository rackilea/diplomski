package com.example.test;
public class MainActivity extends Activity {
  static {
    System.loadLibrary("my");
  }
  public native String stringFromJNI();
}