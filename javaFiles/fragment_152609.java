package my.pckage;

import your.pckage.A;
import your.pckage.C;

public class Test{
    public static void main (String[] args){
        C C = new C();
        c.getNum();// ERROR: Test class doesn't have access to `c`s protected method.
                   // Why should it have, Test doesn't extend C.

        A a = (A)c;// Lets try using other reference
        a.getNum();// Should `a` have access to method that is protected in `C`?
                   // If yes, then what is the point of declaring this method 
                   // protected if all I would have to do to get access to it is 
                   // casting instance of C to A interface?
    }
}