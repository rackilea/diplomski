@XmlRootElement 
class Root{
  @XmlElement(name="entry")
  public List<Entry> entries = Lists.newArrayList();

  void afterUnmarshal(final Unmarshaller unmarshaller, final Object parent) {
    Iterator<Entry> iter = entries.iterator();
    while (iter.hasNext()) {
      if (iter.next().name == null) iter.remove();
    }
  }
}