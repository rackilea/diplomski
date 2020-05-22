for( ; getChild(hole) <= size(); hole = child) {
    for(int i = 0; i < d && tempChild != size(); i++, tempChild++){
        if(heapArray[tempChild + 1].compareTo(heapArray[child]) < 0){
            child = tempChild + 1;
        }
    }

    if (heapArray[child].compareTo(tempElement) < 0)
        heapArray[hole] = heapArray[child];
    else
        break;
}