package de.scrum_master.app;

public class TrackInfo {
  private String info;

  public TrackInfo(String info) {
    this.info = info;
  }

  public String getInfo() {
    return info;
  }

  @Override
  public String toString() {
    return "TrackInfo(" + info + ")";
  }
}