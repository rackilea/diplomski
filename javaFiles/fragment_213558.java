void load(Enumeration e) {
    while(e.hasMoreElements()) {
        queueList.add(e.nextElement());
    }
    fireTableDataChanged();   
}