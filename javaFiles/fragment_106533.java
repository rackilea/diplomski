public class FunctionMT extends Runnable {

    // ...

    private Runnable callback;

    public FunctionMT (final Matrix A_, Matrix B_, Runnable callback) {

        // ...

        this.callback = callback;
    }

    private void spDecomposition() {

        // Do computation.

        SwingUtilities.invokeLater(callback);
    }
}