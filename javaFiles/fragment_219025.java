Method void catchOne()
0:  aload_0
1:  invokevirtual #6   // Method tryItOut:()V
4:  goto          13
7:  astore_1
8:  aload_0
9:  aload_1
10: invokevirtual #5   // Method handleExc:(LTestExc;)V
13: return
Exception table:
From    To      Target      Type
   0     4           7      Class TestExc