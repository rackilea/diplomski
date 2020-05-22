for(int i = 0, i < array.length; i++){
    String temp = array[i];
    System.out.print(temp+" ");
    for(int j = i+1; j < array.length; j++){
        String temp2 = array[j];
        if(temp.compareTo(temp2) == 0){
            System.out.print(temp2+" ");
            i++;
        }
    }
    System.out.println();
}