class SomeClass {
  private volatile Resource resource = null;
  public Resource getResource() {
    if (resource == null) {
      synchronized {
        if (resource == null) 
          resource = new Resource();
      }
    }
    return resource;
  }
}