>java -jar org.eclipse.jdt.core_3.10.2.v20150120-1634.jar -source 1.7 GenericTest.java
----------
1. ERROR in C:\projects\Test\src\GenericTest.java (at line 32)
        Square maxSquare = findMax(new Square[]{new Square(1), new Square(2), new Square(3)});
                           ^^^^^^^
Bound mismatch: The generic method findMax(S[]) of type GenericTest is not applicable for the arguments (GenericTest.Square[]). 
The inferred type GenericTest.Square is not a valid substitute for the bounded parameter <S extends Comparable<S>>
----------
1 problem (1 error)