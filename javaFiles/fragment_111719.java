public class A {
        // Declaration of the 'array' attribute
        public float[] array = new float[]{1.1f, 2.2f, 3.3f};

    }


    import static A.array;
    class B {
        // now I can use 'array' without qualifying it with 'A'
    }