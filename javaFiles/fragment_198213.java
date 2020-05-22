package com.you;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Environment;

public class UnityUrlPlugin {

  private static UnityUrlPlugin m_instance;

  public static UnityUrlPlugin instance() {
    if(m_instance == null)
      m_instance = new UnityUrlPlugin();
    return m_instance;
  }

  private UnityUrlPlugin(){
  }

  public String getURL() {
    return "http://blah.com";
  }
}