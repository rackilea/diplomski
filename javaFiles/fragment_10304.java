package de.scrum_master.app;

import static de.scrum_master.app.Status.*;

public class MyClass {
  private Status status = VALID;

  public void processTracker(TrackInfo trackInfo) {
    if (isValid(getStatus()))
      process(trackInfo);
  }

  public void process(TrackInfo trackInfo) {
    System.out.println("Processing " + trackInfo);
  }

  private Status getStatus() {
    if (status == VALID)
      status = INVALID;
    else
      status = VALID;
    return status;
  }

  boolean isValid(Status status) {
    return status == VALID;
  }

  public static void main(String[] args) {
    MyClass myClass = new MyClass();
    myClass.processTracker(new TrackInfo("normal"));
    myClass.processTracker(new TrackInfo("whatever"));
    myClass.processTracker(new TrackInfo("special"));
  }
}