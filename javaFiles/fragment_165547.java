package de.scrum_master.app;

import de.scrum_master.aspect.Counter;

public class MyCounter {
  @Counter(name = "call_count")
  public void count() {}
}