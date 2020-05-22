public UnitRow getUnits() {
    Unit[] array1and2 = new int[leftChild.getUnits().length + rightChild.getUnits().length];

    for (int i=0; i<leftChild.getUnits().length; i++) {
        array1and2[i]= leftChild.getUnits()[i];
    }

    for (int i=0; i<rightChild.getUnits().length; i++) {
        array1and2[leftChild.getUnits().length + i]= rightChild.getUnits()[i];
    }

    return new UnitRow(array1and2); //add this constructor
}