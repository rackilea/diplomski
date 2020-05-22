void foo1();
  Code:
   0:   invokestatic    #26; //Method getList:()Ljava/util/List;
   3:   invokeinterface #28,  1; //InterfaceMethod java/util/List.iterator:()Ljava/util/Iterator;
   8:   astore_2
   9:   goto    24
   12:  aload_2
   13:  invokeinterface #34,  1; //InterfaceMethod java/util/Iterator.next:()Ljava/lang/Object;
   18:  astore_1
   19:  aload_0
   20:  aload_1
   21:  invokevirtual   #40; //Method process:(Ljava/lang/Object;)V
   24:  aload_2
   25:  invokeinterface #42,  1; //InterfaceMethod java/util/Iterator.hasNext:()Z
   30:  ifne    12
   33:  return

void foo2();
  Code:
   0:   invokestatic    #26; //Method getList:()Ljava/util/List;
   3:   astore_1
   4:   aload_1
   5:   invokeinterface #28,  1; //InterfaceMethod java/util/List.iterator:()Ljava/util/Iterator;
   10:  astore_3
   11:  goto    26
   14:  aload_3
   15:  invokeinterface #34,  1; //InterfaceMethod java/util/Iterator.next:()Ljava/lang/Object;
   20:  astore_2
   21:  aload_0
   22:  aload_2
   23:  invokevirtual   #40; //Method process:(Ljava/lang/Object;)V
   26:  aload_3
   27:  invokeinterface #42,  1; //InterfaceMethod java/util/Iterator.hasNext:()Z
   32:  ifne    14
   35:  return