Method void catchOne()
0   aload_0
1   invokevirtual #6    // Method Example.tryItOut()V
4   return
5   astore_1
6   aload_0
7   aload_1
8   invokevirtual #5   // Method Example.handleExc(LTestExc;)V
11  goto 4
Exception table:
From    To      Target      Type
0       4       5           Class TestExc