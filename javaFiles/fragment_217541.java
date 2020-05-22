int arraySize = b1.getSize();
Integer[] treeToArray = new Integer[arraySize];
iterator iter = b1.iterator();
int i=0;
while(iter.hasNext()) {
    treeToArray[i++] = (Integer)iter.next();
}