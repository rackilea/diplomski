for(num=12 ; num<=101; num++) {   
    org=num ;   
    rev = 0; // added
    while(num>0) {
      rem = num % 10 ; 
      num = num /10 ;
      rev= (10*rev)+rem;
    }
    if(rev==org)
        System.out.println(org);
    num = org; // added
}