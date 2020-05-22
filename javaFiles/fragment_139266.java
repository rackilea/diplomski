public static void g();
    Code:
       0: bipush        100
       2: istore_3      
       3: iconst_0      
       4: istore_0      
       5: goto          26
       8: iconst_0      
       9: istore_1      
      10: goto          18
      13: iconst_3      
      14: istore_2      
      15: iinc          1, 1
      18: iload_1       
      19: iload_3       
      20: if_icmplt     13
      23: iinc          0, 1
      26: iload_0       
      27: iload_3       
      28: if_icmplt     8
      31: return