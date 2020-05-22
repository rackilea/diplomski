class Abc
 {
   Scanner s; //creating global reference of type Scanner
   if(//someCondition)
     {
       s = new Scanner(System.in); //creating new object of type Scanner and pointing it to reference s
     }
   if(//someOtherCondition)
    {
      String str = s.next(); // using that reference in another block
    }
 }