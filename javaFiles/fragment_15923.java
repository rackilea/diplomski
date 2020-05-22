String A=JOptionPane.showInputDialog("Introduce la palabra");
   char s[]=A.toCharArray();   
   for(int i=0; i< s.length; i++ )
   {

      char t='t';      
       if (s[i]==t) 
       {          
          s[i]='T';          

       }        
   } 
   System.out.println(s);