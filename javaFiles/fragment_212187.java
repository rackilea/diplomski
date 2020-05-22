public static void selectionSortByName()  {

    for (int i = 0; i < name.length; i++){

        int smallest =i;
        //invariant is sorted in all n < [i]
        for (int j = i+1; j <= nameArraySize; j++){
            if (name[j].compareTo(name[smallest]) < 0){
                smallest=name[j];
            }
        }

       if(!name[smallest].equals(name[i])){
          swap(name,i,smallest);
       }

    }
  }

  public static void swap(String [] name,int i, int j){                
                String temp = name[j];
                name[j] = name[i];
                name[i] = temp;
  }