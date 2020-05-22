abstract static class C {
        // Not allowed.
        long x = n;
    }

    abstract class D {
        // Allowed.
        long x = n;
    }