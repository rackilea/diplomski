public class InnerStaticFinal {
    class InnerWithConstant {
        static final int n = 0;
        // OKAY! Compile-time constant!
    }
    class InnerWithNotConstant {
        static final Integer n = 0;
        // DOESN'T COMPILE! Not a constant!
    }
}