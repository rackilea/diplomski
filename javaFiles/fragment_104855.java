Comparator<Integer> c =new Comparator<Integer>(){ 
   public int compare(Integer i , Integer j) { 
       int q=i%10;  //use local variables q and w
       int w=j%10;
      if(q>w) 
          return 1;
      else if(q==w) //add this to your code
          return 0;
      else 
          return -1;
      }

};