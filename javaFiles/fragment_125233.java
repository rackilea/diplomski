registerClasses(List(Person.getClass: Class[_]).asJava)

type mismatch;
 found   : java.util.List[Class[_$2]] where type _$2
 required: java.util.List[Class[_]]
Note: Class[_$2] <: Class[_], but Java-defined trait List is invariant in type E.
You may wish to investigate a wildcard type such as `_ <: Class[_]`. (SLS 3.2.10)