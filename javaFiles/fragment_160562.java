public UnitRow getUnits() {
    Unit[] array1and2 = new int[leftChild.getUnits().length + rightChild.getUnits().length];
    System.arraycopy(leftChild.getUnits(), 0, array1and2, 0, leftChild.getUnits().length);
    System.arraycopy(rightChild.getUnits(), 0, array1and2, leftChild.getUnits().length, rightChild.getUnits().length);
    return new UnitRow(array1and2); //add this constructor
}