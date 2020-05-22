> "C:\Program Files\Java\jdk1.7.0_80\bin\javac.exe" GenericTest.java
GenericTest.java:32: error: method findMax in class GenericTest cannot be applied to given types;
                Square maxSquare = findMax(new Square[]{new Square(1), new Square(2), new Square(3)});
                                   ^
  required: S[]
  found: Square[]
  reason: inferred type does not conform to declared bound(s)
    inferred: Square
    bound(s): Comparable<Square>
  where S is a type-variable:
    S extends Comparable<S> declared in method <S>findMax(S[])
1 error