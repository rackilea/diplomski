// (Really an API would be using super and extends here,
//   but let's keep it simple.)
public static <T> void spilledOn (Stack<T> st1,Stack<T> st2){
    //        ^^^                       ^            ^
[...]
// (I'm using a different name (E vs T) here
//     just to illustrate that I am declaring two variables.
//   Using the same letter would be more conventional.)
public static <E> int findLengthInStack (Stack<E> st1){
    //        ^^^                              ^
    Stack<E> tmp=new Stack<>();
    //    ^