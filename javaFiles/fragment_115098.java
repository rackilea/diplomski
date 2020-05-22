public ArrayList<iSomeInterface> sorting(){
    Collections.sort(interfaces, new Comparator<iSomeInterface>() {
        @Override
        public int compare(iSomeInterface i1, iSomeInterface i2) {
            return i1.getLevel() - i2.getLevel();
        }
    });
    return interfaces;
}