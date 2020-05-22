class Class2 extends JPanel{
        private int xPos, yPos;
        public void createJFrame(){
                JFrame window = new JFrame();
                // Class2 obj2 = new Class2();
                window.setVisible(true);
                window.setSize(300, 300);
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Container c = window.getContentPane();
                c.add(this); // now the setValue will update the object
        }
...