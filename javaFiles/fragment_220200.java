int found=-1;
int index=0;
while (index<list.size()){
    if(list.get(index).equals(z)){
        found=index;
    }
    index++;
}
return found;