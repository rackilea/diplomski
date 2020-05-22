for(int i=0; i<count; i++){
    //random index of element that must be added to result
    int index = new Random().nextInt(myarray.length);
    result.add(myarray[index]);
    myarray.remove(index);
}