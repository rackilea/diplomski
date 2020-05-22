@Override
public Set getRows(){
    return matrix.keySet();
}
@Override
public Set getCols(Long row){
    return matrix.get(row).keySet();
}