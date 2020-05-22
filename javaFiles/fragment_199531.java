public static void main(String[] args) 
{
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            Test test = new Test();
            test.setVisible(true);
        }
});