>> javac -Xlint Test.java
Test.java:17: warning: [rawtypes] found raw type: Comparable
public static <T extends Comparable> T findMax2(List<T> list, int first, int second) {
                         ^
  missing type arguments for generic class Comparable<T>
  where T is a type-variable:
    T extends Object declared in interface Comparable

Test.java:20: warning: [unchecked] unchecked call to compareTo(T) as a member of the raw type Comparable
        if (list.get(i).compareTo(max)>0) max = list.get(i);
                                 ^
  where T is a type-variable:
    T extends Object declared in interface Comparable
2 warnings