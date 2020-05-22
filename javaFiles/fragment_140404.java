boolean first = true;
for(int val : size){
    if(first){
        System.out.print(val);
        first = false;
    } else {
        System.out.print(" " + val);
    }
 }