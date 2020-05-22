int empty = 0;  
for(int f=0;f<list.length-1;f++){
    if(list[f] == 0) {
        empty = f;
    }
}

list[empty] = value;