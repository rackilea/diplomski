int returnResult;
for (int i=3;i>=0;i--){
    returnResult = someMethod(arrayList.get(i));
    if (returnResult == -1){
        arrayList.remove(i);
    }
}