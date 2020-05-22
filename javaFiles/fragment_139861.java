class EntryAdapter extends XmlAdapter<EntryAdapter.Entry, Integer>
{
    public EntryAdapter.Entry marshal(Integer id) {
        return new Entry(id);
    }

    public Integer unmarshal(Entry e) {
        return e.getId();
    }

    static class Entry 
    {
        private Integer id;

        public Entry() {}
        public Entry(Integer id) { this.id = id; }

        @XmlAttribute
        public Integer getId() { return id; }
        public void setId(Integer id) { this.id = id; }
    }
}