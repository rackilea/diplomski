public static boolean expensiveComputation() {
        for (int i = 0; i < Integer.MAX_VALUE; ++i);
        b = false;
        return false;
}

public static boolean b = true;
public static void main(String[] args) {
        if (expensiveComputation() || b) {
        // do stuff
        }
}