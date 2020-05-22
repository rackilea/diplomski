public class MyList<T> implements List<T> {

// V1 (compiler warning)
public <T> T[] toArray(T[] array) {
    // in this method T refers to the generic parameter of the generic method
    // rather than to the generic parameter of the class. Thus we get a warning.
    T variable = null; // refers to the element type of the array, which may not be the element type of MyList
} 

// V2 (no warning)
public <T2> T2[] toArray(T2[] array) {
    T variable = null; // refers to the element type of MyList
    T2 variable2 = null; // refers to the element type of the array
}