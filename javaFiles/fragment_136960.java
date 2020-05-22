import java.util.*;
class ScorpMain {

    /* This interface just has a single method on it returning an int */
    static interface SomeInterface {
        int foo();
    }

    /**
     * ExampleKey has an int and a string. It considers itself to be equal to
     * another object if that object implements SomeInterface and the two have
     * equal foo values. It believes this is sufficient, as its sole purpose is
     * to calculate this foo value.
     */
    static class ExampleKey implements SomeInterface {
        int i;
        String s;
        ExampleKey(int i, String s) { this.i = i; this.s = s; }
        public int foo() { return i * s.length(); }
        public int hashCode() { return i ^ s.hashCode(); }
        // notice - equals takes Object, not ExampleKey
        public boolean equals(Object o) {
            if(o instanceof SomeInterface) {
                SomeInterface so = (SomeInterface)o;
                System.out.println(so.foo() + " " + foo());
                return so.foo() == foo();
            }
            return false;
        }
    }

    /**
     * The ImposterKey stores it's foo and hash value. It has no calculation 
     * involved. Note that its only relation to ExampleKey is that they happen
     * to have SomeInterface.
     */
    static class ImposterKey implements SomeInterface {
        int foo;
        int hash;
        ImposterKey(int foo, int hash) { this.foo = foo; this.hash = hash; }
        public int foo() { return foo; }
        public boolean equals(Object o) {
                SomeInterface so = (SomeInterface)o;
                return so.foo() == foo();
        }
        public int hashCode() { return hash; }
    }

    /**
     * In our main method, we make a map. We put a key into the map. We get the
     * data from the map to prove we can get it out. Then we make an imposter, 
     * and get the data based on that. 
     * The moral of the story is, Map.get isn't sacred: if you can trick it 
     * into thinking that the object inside is equal to the object you give it 
     * in both equality and hash, it will give you the resulting object. It 
     * doesn't have anything to do with the type except that a given type is 
     * unlikely to be equal to another object that isn't of the given type.
     * This may seem like a contrived example, and it is, but it is something 
     * to be conscious of when dealing with maps. It's entirely possible you 
     * could get the same data and not realize what you're trying to do. Note 
     * you cannot ADD the imposter, because that IS checked at compile time.
     */
    public static void main(String[] args) {
        Map<ExampleKey,String> map = new HashMap<ExampleKey,String>();
        ExampleKey key = new ExampleKey(1337,"Hi");
        map.put(key,"Awesome!");
        String get = map.get(key);
        System.out.println(get); // we got awesome
        ImposterKey imposter = new ImposterKey(2674,3096); // make an imposter
        String fake = map.get(imposter);
        System.out.println(fake); // we got awesome again!
    }
}