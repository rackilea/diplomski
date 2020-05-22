int count = 0;
    for(int i =0; i<a.length; i++){
        if(Character.isUpperCase(a[i].charAt(0))){
            num++;
        }
        if(!a[i].equals("$")){ // copy only non "$" Strings to the output array
            b[count] =a[i];
            count++;
        }
    }