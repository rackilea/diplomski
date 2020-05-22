public class MyButton extends JButton implements ActionListener
{
    private Semaphore sem = new Semaphore(1);

    public MyButton(String text) throws InterruptedException
    {
        super(text);
        addActionListener(this);
        sem.acquire();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        sem.release();
    }

    public void waitForPress() throws InterruptedException {
        sem.acquire();
        //do your stuff
        sem.acquire();
        //or just
        //waitForPress()
            //if you dont want it to end.
    }

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame();
        MyButton m = new MyButton("test");
        frame.add(m);
        frame.pack();
        frame.setVisible(true);
        m.waitForPress();
        //another time, if you only want it to block twice
        m.waitForPress();
    }
}