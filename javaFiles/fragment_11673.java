String[] a ={"BLAH00001","DIK-11","DIK-2","MAN5"};
 for(String g:a)
  System.out.println(Integer.valueOf(g.split("^[A-Z]+\\-?")[1]));

 /*******************************  
   Regex Explanation :
     ^  --> StartWith
    [A-Z]+ --> 1 or more UpperCase
    \\-? --> 0 or 1 hyphen   
*********************************/