public class MyFormatterTest extends JFrame {

    public MyFormatterTest() {

        setTitle("Example");
        JPanel panel = new JPanel();
        JLabel label = new JLabel("text :");
        JPersianTextField2 tf = new JPersianTextField2();
        tf.setText("سلام من مهدی هستم برنامه نویس ارشد 31 ساله"); //Hi This is mehdi, 31 years old Sr. software developer
        panel.add(label);
        panel.add(tf);

        JButton button2 = new JButton();
        button2.setText("getText");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(tf.getText());
            }
        });

        panel.add(button2);


        getContentPane().add(panel, BorderLayout.SOUTH);
        pack();

    }

    public static void main(String[] args) {

        //Available Locales inside Your JVM
        for (Locale l : Locale.getAvailableLocales()) {
            System.out.println(l.getCountry() + ":" + l.getLanguage());
        }

        MyFormatterTest mfe = new MyFormatterTest();
        mfe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mfe.setVisible(true);
    }
}