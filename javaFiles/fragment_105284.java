public <S extends Item> void withExtra1(S...);
    descriptor: ([LItem;)V
    flags: (0x0081) ACC_PUBLIC, ACC_VARARGS
    Code:
      stack=2, locals=2, args_size=2
         0: aload_0
         1: getfield      #2                  // Field pool:Ljava/util/List;
         4: aload_1
         5: invokestatic  #3                  // Method java/util/Collections.addAll:(Ljava/util/Collection;[Ljava/lang/Object;)Z
         8: pop
         9: return
      LineNumberTable:
        line 9: 0
        line 10: 9
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0      10     0  this   LItem;
            0      10     1 extra   [LItem;
      LocalVariableTypeTable:
        Start  Length  Slot  Name   Signature
            0      10     1 extra   [TS;
    Signature: #23                          // <S:LItem;>([TS;)V


  public void withExtra2(Item...);
    descriptor: ([LItem;)V
    flags: (0x0081) ACC_PUBLIC, ACC_VARARGS
    Code:
      stack=2, locals=2, args_size=2
         0: aload_0
         1: getfield      #2                  // Field pool:Ljava/util/List;
         4: aload_1
         5: invokestatic  #3                  // Method java/util/Collections.addAll:(Ljava/util/Collection;[Ljava/lang/Object;)Z
         8: pop
         9: return
      LineNumberTable:
        line 13: 0
        line 14: 9
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0      10     0  this   LItem;
            0      10     1 extra   [LItem;