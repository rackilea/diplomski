public int compareTo(First other){
if (eId < other.getEId()){ 
    return -1;
} else if (eId > other.getEId()){
    return +1;
} else {
    return 0;
}
}