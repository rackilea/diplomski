public class NoSuchElementExceptionDemo{
    public static void main(String args[]) {
        Hashtable sampleMap = new Hashtable();
        Enumeration enumeration = sampleMap.elements();
        enumeration.nextElement();  //java.util.NoSuchElementExcepiton here because enumeration is empty
    }
}

Output:
Exception in thread "main" java.util.NoSuchElementException: Hashtable Enumerator
        at java.util.Hashtable$EmptyEnumerator.nextElement(Hashtable.java:1084)
        at test.ExceptionTest.main(NoSuchElementExceptionDemo.java:23)