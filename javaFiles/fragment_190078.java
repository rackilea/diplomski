public class SomeClass
{
    int privateMember;

    // note it's important to override hashCode, since if the hashCode of two
    // keys is not the same, equals() won't be called at all
    public int hashCode ()
    {
        return privateMember;
    }

    public boolean equals (Object other)
    {
        if (other instanceof SomeClass) {
            return this.privateMember==((SomeClass)other).privateMember;
        }
        else { 
            return false;
        }
    }

    public static void main(String[] args)
    {
        HashMap<SomeClass,String> map = new HashMap<SomeClass,String>();
        SomeClass s1 = new SomeClass ();
        SomeClass s2 = new SomeClass ();
        s1.priv=4;
        s2.priv=4;
        map.put (s1, "something");
        if (map.containsKey (s2)) {
            System.out.println ("found!");
        } else {
            System.out.println ("not found!");
        }
    }
}