@XmlRootElement 
class Entry{
  @XmlElement(name="name",required=true)
  public String name;

  private boolean isValidEntry() {
    return name != null;
  }

  void afterUnmarshal(final Unmarshaller unmarshaller, final Object parent) {
    if (!isValidEntry()) {
      // entry not yet added to parent - use a patcher
      UnmarshallingContext.getInstance().addPatcher(new Patcher() {
        public void run() throws SAXException {
          ((Root)parent).removeEntry(this);
        }
      });
    }
  }
}