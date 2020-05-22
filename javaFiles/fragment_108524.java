public class test extends JFrame {
    ....    
    private CountDownLatch latch;
    private int N;

    public int setVisible() throws InterruptedException{

        latch = new CountDownLatch(1);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setVisible(true);
            }
        });

        latch.await();   // <== block until countDown called
        return N;
    }

    public test() {           
        ...
        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                N=5;
                latch.countDown();   <== will unblock await() call
                dispose();

            }
        });
        ...
    }

}