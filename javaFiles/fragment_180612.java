import java.util.*;

public class Super
{
    static Map<Object, Super> owners = new IdentityHashMap<Object, Super>();
    // IdentityHashMap will not work with primitives due to autoboxing,
    // but HashMap requires all field values to have sensible implementations
    // of hashCode() and equals().

    /** Gets the owner associated with a field. */
    public static Object getOwner(Object field)
    {
        return owners.get(field);
    }

    /** Establishes ownership over a field. */
    protected void own(Object field)
    {
        owners.put(field, this);
    }

    /** Removes an ownership, but only if this is the owner. */
    protected void disown(Object field)
    {
        if (owners.get(field) == this) owners.remove(field);
    }

    /** Shorthand for disown(oldField); own(newField). */
    protected <T> T change(T oldField, T newField)
    {
        disown(oldField);
        own(newField);
        return newField;
    }
}

public class SubA extends Super
{
    protected String s;
    protected Integer i;

    public SubA(String aString, Integer anInt) { setS(aString); setI(anInt); }
    public void setS(String aString) { s = change(s, aString); }
    public void setI(Integer anInt) { i = change(i, anInt); }
    public String toString() { return "SubA(" + s + "," + i + ")"; }
}

public class SubB extends Super
{
    protected Object o;

    public SubB(Object anObject) { setO(anObject); }
    public void setO(Object anObject) { o = change(o, anObject); }
    public String toString() { return "SubB(" + o + ")"; }
}

public class Demo
{
    public static void main(String[] args)
    {
        String s1 = "String1", s2 = "String2", s3 = "String3";
        Integer i1 = 111, i2 = 222;
        Object o1 = new Object(), o2 = new Object();

        SubA a1 = new SubA(s1, i1), a2 = new SubA(s2, i2);
        SubB b = new SubB(o1);

        p("s1 owner = %s", Super.getOwner(s1)); // SubA(String1,111)
        p("s2 owner = %s", Super.getOwner(s2)); // SubB(String2,222)
        p("s3 owner = %s", Super.getOwner(s3)); // null
        p("i1 owner = %s", Super.getOwner(i1)); // SubA(String1,111)
        p("i2 owner = %s", Super.getOwner(i2)); // SubA(String2,222)
        p("o1 owner = %s", Super.getOwner(o1)); // SubB(java.lang.Object@...)
        p("o2 owner = %s", Super.getOwner(o2)); // null

        p("s1 -> s3, o1 -> o2");
        a1.setS(s3);
        b.setO(o2);

        p("s1 owner = %s", Super.getOwner(s1)); // null
        p("s3 owner = %s", Super.getOwner(s3)); // SubA(String3,111)
        p("o1 owner = %s", Super.getOwner(o1)); // null
        p("o2 owner = %s", Super.getOwner(o2)); // SubB(java.lang.Object@...)
    }

    static void p(String fmt, Object... args)
    {
        System.out.format(fmt, args);
        System.out.println();
    }
}