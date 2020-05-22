package com.gwt.example.myproject.client;

public class Login implements EntryPoint {

  public void onModuleLoad() {
    ... create loginWidget ..

    RootPanel.get("my-login-div").add(loginWidget);

  }

}