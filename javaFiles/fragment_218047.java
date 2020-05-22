public class Test {
    int f; // field declaration
    { // init block
        int f; // VALID: local declaration hiding field
        { // nested local block
            int f; // NOT VALID: local declaration in same init block
        }
    }
}