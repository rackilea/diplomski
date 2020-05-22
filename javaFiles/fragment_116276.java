int size=values.length;
    int [] SortedbyValue=new int [size];
    for(int i=0;i<size;i++){
        SortedbyValue[values[i]]=i;
    }
    return SortedbyValue;