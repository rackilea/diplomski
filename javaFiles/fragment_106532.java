public class MainWindow extends JFrame {

    private void fButtonActionPerformed(java.awt.event.ActionEvent e) {

        // ...

        FunctionMT f = new FunctionMT (A, B, new Runnable() {
            @Override
            public void run() {
                results.print(B);
                scene.update(B);
                scene.repaint();
            }
        });
        Thread t = new Thread(f);
        t.start();

        // Wait for computation:
        // won't do it here.
        // results.print(B);
        // scene.update(B);
        // scene.repaint();
    }
}