public void onStart(Application app)
  {
    super.onStart(app);
    String value = app.configuration().getString("my.thing");
    // do something with value
  }