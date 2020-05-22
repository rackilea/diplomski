@Override
public int getCount(){
    return list.size();
}

@Override
public Exhibition getItem (int pos){
    return list.get(pos);
}

void resetData() {
    list = originalList;
}