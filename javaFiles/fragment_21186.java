public final static outsideRepeat()V
L0
LINENUMBER 8 L0
BIPUSH 97
ISTORE 1
NEW kotlin/ranges/CharRange
DUP
ILOAD 1
BIPUSH 122
INVOKESPECIAL kotlin/ranges/CharRange.<init> (CC)V // range created outside loop
ASTORE 0
L1
LINENUMBER 9 L1
SIPUSH 1024
ISTORE 1
L2
L3
ICONST_0
ISTORE 2
ILOAD 1
ISTORE 3
L4
ILOAD 2
ILOAD 3
IF_ICMPGE L5 // termination condition
L6
ILOAD 2
ISTORE 4
L7
ICONST_0
ISTORE 5
L8
LINENUMBER 10 L8
ALOAD 0
INVOKESTATIC FooKt.random (Lkotlin/ranges/CharRange;)Ljava/lang/Object;
INVOKESTATIC FooKt.doSomething (Ljava/lang/Object;)Ljava/lang/Object;
POP