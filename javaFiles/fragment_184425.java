@Test
public void test(){
    String[] garList = new String[] {"A", "B", "C", "A", "E", "A"};

    //remove duplicates 
    String[] noDup = new String[garList.length];
    for(int i =0; i<garList.length; i++){
        if(!contains(noDup, garList[i])){
            noDup[i] = garList[i];
        }
    }
    System.out.println(Arrays.toString(noDup));
    // move nulls to the end
    String[] tailNull = new String[garList.length];
    int j = 0;
    for (int i = 0; i < noDup.length; i++) {
        if(noDup[i]!=null){
            tailNull[j] = noDup[i];
            j++;
        }
    }
    System.out.println(Arrays.toString(tailNull) + "/" + j);
    // copy range of not null elements 
    String[] noNull = new String[j];
    System.arraycopy(tailNull, 0, noNull, 0, j);
    System.out.println(Arrays.toString(noNull));
}

boolean contains(String[] array, String o){
    for (int i = 0; i < array.length; i++) {
        if(o.equals(array[i]))
            return true;
    }
    return false;
}