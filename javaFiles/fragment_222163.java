public static void call(int, int);
    Code:
       0: iload_0
       1: iload_1
       2: if_icmplt     10
       5: goto_w        32781
      10: iinc          1, 1
      13: iinc          1, 1
      ....
    32770: iinc          1, 1
    32773: iinc          1, 1
    32776: goto_w        32781
    32781: getstatic     #3             // Field java/lang/System.out:Ljava/io/PrintStream;
    32784: iload_1
    32785: invokevirtual #4             // Method java/io/PrintStream.println:(I)V
    32788: return