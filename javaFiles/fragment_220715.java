String attr_A = request.getAttr_A();
List<ArrayClass> arrayClassList = request.getArray_A();
for(ArrayClass arrayClass : arrayClasslist){
    String attr_B = arrayClass.getAttr_B();
    saveTableB(attr_A, attr_B);
}