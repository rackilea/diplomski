class StringWrapper{
    final String s;
    public StringWrapper(String s){
        this.s=s;
    }
    @Override
    public String toString() {
        return s;
    }
}

JComboBox cb = new JComboBox(new StringWrapper[]{ 
            new StringWrapper("one"),
            new StringWrapper("two"),
            new StringWrapper("three")});
cb.insertItemAt(new StringWrapper(null), 0);