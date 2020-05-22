List<Integer>  a = new ArrayList<Integer>();
for (Integer integer : a)
{
  integer.toString();
}
// Byte code
 ALOAD 1
 INVOKEINTERFACE java/util/List.iterator()Ljava/util/Iterator;
 ASTORE 3
 GOTO L2
L3
 ALOAD 3
 INVOKEINTERFACE java/util/Iterator.next()Ljava/lang/Object;
 CHECKCAST java/lang/Integer
 ASTORE 2 
 ALOAD 2
 INVOKEVIRTUAL java/lang/Integer.toString()Ljava/lang/String;
 POP
L2
 ALOAD 3
 INVOKEINTERFACE java/util/Iterator.hasNext()Z
 IFNE L3