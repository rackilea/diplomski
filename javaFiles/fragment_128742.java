public void $$_hibernate_write_title(String paramString)
{
    if (!EqualsHelper.areEqual(this.title, paramString)) {
      $$_hibernate_trackChange("title");
    }
    this.title = paramString;
}

public void $$_hibernate_trackChange(String paramString)
{
    if (this.$$_hibernate_tracker == null) {
      this.$$_hibernate_tracker = new SimpleFieldTracker();
    }
    this.$$_hibernate_tracker.add(paramString);
}