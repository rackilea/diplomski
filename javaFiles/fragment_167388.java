public Integer max(){
 //return largest value in dt; null if size == 0
    Integer biggest = dt[0]
    if (size == 0) return null;
    else{
        ;//trouble here; changing to int won't help     & var name also  
        for (int j = 0; j < size ; j++) {
            if (dt[j] < biggest) biggest = dt[j];
        }
    }
    return biggest;
}