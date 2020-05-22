public ArrayList<iSomeInterface> sorting(){

    Collections.sort(someInterfaces, (iSomeInterface  i1, iSomeInterface  i2) -> i1.getLevel() - i2.getLevel());

    return someInterfaces;
}