if(myList == null){
    smth = abc;
} else {
    for(myList myListItem : myList){            
        if(myList.getId() != null){
          if(TEST1.equals(myListItem.getId())){
            smth = abc;
          } else if(TEST2.equals(myListItem.getId())){
            smth = xyz;
          } else if(TEST3.equals(myListItem.getId())){
            smth = pqr;
        }
    }  
 }
   return smth;
    }