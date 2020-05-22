>"C:\Program Files\Java\jdk1.8.0_40\bin\javac.exe" GenericTest.java
GenericTest.java:32: error: incompatible types: inference variable S has incompatible bounds
                Square maxSquare = findMax(new Square[]{new Square(1), new Square(2), new Square(3)});
                                          ^
    equality constraints: Shape
    upper bounds: Square,Comparable<S>
  where S is a type-variable:
    S extends Comparable<S> declared in method <S>findMax(S[])
1 error