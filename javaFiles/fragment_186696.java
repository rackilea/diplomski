0: getstatic #2 // Field HALF_OF_MEMORY:I 
 3: newarray byte 
 5: astore_0 <==== array ref in slot #0 

 6: aload_0 
 7: astore_1 <==== array ref in slot #1 

 8: aload_1 
 9: arraylength 
10: istore_2 

11: iconst_0 
12: istore_3 

13: iload_3 
14: iload_2 
15: if_icmpge 29 

18: aload_1 
19: iload_3 
20: baload 
21: istore 4 
23: iinc 3, 1 
26: goto 13 

29: aconst_null 
30: astore_0 <== nulls slot #0 

31: getstatic #2 // Field HALF_OF_MEMORY:I 
34: newarray byte 
36: astore_1 
37: getstatic #3 // Field java/lang/System.out:Ljava/io/PrintStream; 
40: ldc #4 // String Success 
42: invokevirtual #5 // Method java/io/PrintStream.println:(Ljava/lang/String;)V 
45: return