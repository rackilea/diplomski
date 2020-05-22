int foo(int, int);
Code:
   0: iload_1       
   1: iload_2       
   2: if_icmpeq     10
   5: iload_1       
   6: iload_2       
   7: if_icmple     12
  10: iconst_1      
  11: ireturn       
  12: iconst_0      
  13: ireturn       

int bar(int, int);
Code:
   0: iload_1       
   1: iload_2       
   2: if_icmplt     7
   5: iconst_1      
   6: ireturn       
   7: iconst_0      
   8: ireturn