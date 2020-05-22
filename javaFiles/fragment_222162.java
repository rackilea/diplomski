public static void call(int, int);
    Code:
       0: iload_0
       1: iload_1
       2: if_icmpge     32768
       5: iinc          1, 1
       8: iinc          1, 1

       ...(10921 times) ...

    32762: iinc          1, 1
    32765: iinc          1, 1
    32768: getstatic     #3             // Field java/lang/System.out:Ljava/io/PrintStream;
    32771: iload_1
    32772: invokevirtual #4             // Method java/io/PrintStream.println:(I)V
    32775: return