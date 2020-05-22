public class ClassB extends JFrame{
    ClassB(){
        super();
        setSize(200, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JButton button = new JButton("ClassA");

        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new ClassA();
                ClassB.this.dispose();
            }
        });
        Container container = getContentPane();
        container.add(button);
        setVisible(true);
    }   
}