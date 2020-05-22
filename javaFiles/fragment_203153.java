new AbstractListModel() {
    String [] values = new String [];
    for (int jln = 0; jln < TraitList.size(); jln++){
        values [jln] = (TraitList.get(jln).id + " - " + TraitList.get(jln).Name);
    }
    public int getSize() {
        return values.length;
    }
    public Object getElementAt(int index) {
        return values[index];
    }
}