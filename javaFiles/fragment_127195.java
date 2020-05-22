boolean found;
for(int i=0; i<values.length; i++){
    found = false;
    for(int j=0; j<number.length; j++){
        if(values[i]==number[j]){
            found = true
        }
    }
    if(found){               
        System.out.println("Number is found");
    } else {
        System.out.println("Number is not found");
    }
}