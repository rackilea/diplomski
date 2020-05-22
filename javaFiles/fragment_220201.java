int index=list.size() - 1;
while (index >= 0){
    if(list.get(index).equals(z)){
        return index;
    }
    index--;
}
return -1;