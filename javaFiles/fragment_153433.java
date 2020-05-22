Integer i = 256;
    Integer j=i;
    System.out.println(i==j);         //True  (Because we are pointing the same object)
    i--;
    i++;        
    System.out.println(i==j);         //False (Because reference has changed)
    System.out.println(i.equals(j));  //True  (Because the inner state is the same)