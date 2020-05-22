public final static insideRepeat()V
    L0
    LINENUMBER 2 L0
    SIPUSH 1024
    ISTORE 0
    L1
    L2
    ICONST_0
    ISTORE 1
    ILOAD 0
    ISTORE 2
    L3
    ILOAD 1
    ILOAD 2
    IF_ICMPGE L4 // loop termination condition
    L5
    ILOAD 1
    ISTORE 3
    L6
    ICONST_0
    ISTORE 4
    L7 // loop body
    LINENUMBER 3 L7
    BIPUSH 97
    ISTORE 5
    NEW kotlin/ranges/CharRange
    DUP
    ILOAD 5
    BIPUSH 122
    INVOKESPECIAL kotlin/ranges/CharRange.<init> (CC)V // new instance created inside the loop
    INVOKESTATIC FooKt.random (Lkotlin/ranges/CharRange;)Ljava/lang/Object;
    INVOKESTATIC FooKt.doSomething (Ljava/lang/Object;)Ljava/lang/Object;
    POP