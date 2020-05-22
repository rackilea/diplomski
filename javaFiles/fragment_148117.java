jshell>  ArrayList<Long> lst = new ArrayList<>();            
lst ==> []

jshell> lst.add(2);
|  Error:
|  no suitable method found for add(int)
|      method java.util.Collection.add(java.lang.Long) is not applicable
|        (argument mismatch; int cannot be converted to java.lang.Long)
|      method java.util.List.add(java.lang.Long) is not applicable
|        (argument mismatch; int cannot be converted to java.lang.Long)
|      method java.util.AbstractCollection.add(java.lang.Long) is not applicable
|        (argument mismatch; int cannot be converted to java.lang.Long)
|      method java.util.AbstractList.add(java.lang.Long) is not applicable
|        (argument mismatch; int cannot be converted to java.lang.Long)
|      method java.util.ArrayList.add(java.lang.Long) is not applicable
|        (argument mismatch; int cannot be converted to java.lang.Long)
|  lst.add(2);
|  ^-----^

jshell> lst.add(2l);
$2 ==> true