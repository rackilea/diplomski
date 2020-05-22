package com;
import com.mgr_api_types.*;

public class mgr_api_JNI
{
  static {
    try {
      System.loadLibrary("Mngr"); // Use "-Djava.library.path=[path to library]" option to load this library
    } catch (UnsatisfiedLinkError e) {
      System.err.println("Native code library 'Mngr' failed to load.\n" + e);
    }
  }

  public native void createInstance(  com.mgr_api_types.EDisplayType displayType,
                                      String displaySerialNumber,
                                      com.mgr_api_types.ECommType commType,
                                      String portName);

  public static void main(String [] arg) {

    mgr_api_JNI obj = new mgr_api_JNI();
    obj.createInstance(new com.mgr_api_types.EDisplayType(), "", new com.mgr_api_types.ECommType(), "");

  }
}