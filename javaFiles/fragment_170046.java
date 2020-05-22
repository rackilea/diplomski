public class ClassA extends JFrame{
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("helo moto");
        ClassA a = new ClassA();
    }

    ClassA(){
        super();
        setSize(200, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JButton button = new JButton("ClassB");
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new ClassB();
                ClassA.this.dispose();
            }
        });
        Container container = getContentPane();
        container.add(button);
        setVisible(true);
    }
}