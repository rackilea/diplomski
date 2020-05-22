enum ParseTags {
  CODE {
    public void set(Entry entry, String value) { 
      entry.setCode(value);
    }
  },
  ...;
  public abstract void set(Entry entry, String value);
}