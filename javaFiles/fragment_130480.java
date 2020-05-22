public int h1();
Code:
   0: aload_0       
   1: getfield      #17                 // Field hash:I
   4: istore_1      
   5: iload_1       
   6: ifne          50
   9: aload_0       
  10: getfield      #15                 // Field value:[C
  13: arraylength   
  14: ifle          50
  17: aload_0       
  18: getfield      #15                 // Field value:[C
  21: astore_2      
  22: iconst_0      
  23: istore_3      
  24: goto          39
  27: bipush        31
  29: iload_1       
  30: imul          
  31: aload_2       
  32: iload_3       
  33: caload        
  34: iadd          
  35: istore_1      
  36: iinc          3, 1
  39: iload_3       
  40: aload_2       
  41: arraylength   
  42: if_icmplt     27
  45: aload_0       
  46: iload_1       
  47: putfield      #17                 // Field hash:I
  50: iload_1       
  51: ireturn