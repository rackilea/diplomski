public String toString(){
    String allstr="";
    for (int i = 0; i < this.myArray.length; i++){
        if (isChanged[i] == true) 
            allstr = allstr + (this.myArray[i] + " ");
    }

    return allstr;
}