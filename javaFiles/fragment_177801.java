import java.util.*;
import java.lang.*;

interface Metal extends Cloneable {
    public Metal clone();
}

class Iron implements Metal {

    public int val = 101;

    public Iron clone() {
        try {
            return (Iron) super.clone();
        } catch (CloneNotSupportedException e) {        
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public String toString() { return "Iron " + val; }
}

class Rextester
{  
    public static void main(String args[])
    {
        Metal metal = new Iron();
        Metal metal2 = metal.clone();

        ((Iron)metal).val = 200; // just to make sure metal2 is cloned

        System.out.println(metal2); // outputs: Iron 101
    }
}