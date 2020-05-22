0: aload_0
   1: invokevirtual #2           // Method java/lang/Object.getClass:()Ljava/lang/Class;
   4: invokevirtual #3           // Method java/lang/Class.getSimpleName:()Ljava/lang/Str
   7: astore_1
   8: aload_1
   9: astore_2
  10: iconst_m1
  11: istore_3
  12: aload_2
  13: invokevirtual #4           // Method java/lang/String.hashCode:()I
  16: lookupswitch  { // 6
       -1932803762: 118
       -1932797868: 132
       -1808118735: 90
                65: 146
                66: 76
         578806391: 104
           default: 157
      }
  76: aload_2
  77: ldc           #5           // String B
  79: invokevirtual #6           // Method java/lang/String.equals:(Ljava/lang/Object;)Z
  82: ifeq          157
  85: iconst_0
  86: istore_3
  87: goto          157
  90: aload_2
  91: ldc           #7          // String String
  93: invokevirtual #6          // Method java/lang/String.equals:(Ljava/lang/Object;)Z
  96: ifeq          157
  99: iconst_1
 100: istore_3
 101: goto          157
 104: aload_2
 105: ldc           #8          // String ArrayList
 107: invokevirtual #6          // Method java/lang/String.equals:(Ljava/lang/Object;)Z
 110: ifeq          157
 113: iconst_2
 114: istore_3
 115: goto          157
 118: aload_2
 119: ldc           #9           // String HashMap
 121: invokevirtual #6           // Method java/lang/String.equals:(Ljava/lang/Object;)Z
 124: ifeq          157
 127: iconst_3
 128: istore_3
 129: goto          157
 132: aload_2
 133: ldc           #10           // String HashSet
 135: invokevirtual #6            // Method java/lang/String.equals:(Ljava/lang/Object;)Z
 138: ifeq          157
 141: iconst_4
 142: istore_3
 143: goto          157
 146: aload_2
 147: ldc           #11           // String A
 149: invokevirtual #6            // Method java/lang/String.equals:(Ljava/lang/Object;)Z
 152: ifeq          157
 155: iconst_5
 156: istore_3
 157: iload_3
 158: tableswitch   { // 0 to 5
                 0: 196
                 1: 196
                 2: 196
                 3: 196
                 4: 196
                 5: 196
           default: 196
      }
 196: return