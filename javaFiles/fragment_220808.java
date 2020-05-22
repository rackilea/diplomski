List<Integer>  a = new ArrayList<Integer>();
for (Iterator iterator = a.iterator(); iterator.hasNext();)
{
  Integer integer = (Integer) iterator.next();
  integer.toString();
}
// Bytecode:
 ALOAD 1
 INVOKEINTERFACE java/util/List.iterator()Ljava/util/Iterator;
 ASTORE 2
 GOTO L7
L8
 ALOAD 2
 INVOKEINTERFACE java/util/Iterator.next()Ljava/lang/Object;
 CHECKCAST java/lang/Integer
 ASTORE 3
 ALOAD 3
 INVOKEVIRTUAL java/lang/Integer.toString()Ljava/lang/String;
 POP
L7
 ALOAD 2
 INVOKEINTERFACE java/util/Iterator.hasNext()Z
 IFNE L8