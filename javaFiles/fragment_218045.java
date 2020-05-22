public class Test {
    int f; // field declaration
    { // init block
        int f; // WARNING: Local variable f is hiding a field from type Test 
    }
}