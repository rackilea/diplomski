public static void f();
    Code:
       0: bipush        100
       2: istore_0      
       3: iconst_0      
       4: istore_1      
       5: goto          26
       8: iconst_0      
       9: istore_2      
      10: goto          18
      13: iconst_3      
      14: istore_3      
      15: iinc          2, 1
      18: iload_2       
      19: iload_0       
      20: if_icmplt     13
      23: iinc          1, 1
      26: iload_1       
      27: iload_0       
      28: if_icmplt     8
      31: return