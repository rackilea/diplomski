//---implements ActionListener---
public class Button implements ActionListener{

    private int clickCount;

    public Button() {

        clickCount = 0;

        JFrame god = new JFrame ();
        god.setSize(new Dimension(400, 400));

        //if you don't do this, your program still running, even if you click on X.
        god.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        JPanel panel = new JPanel();

        god.add(panel);

        JButton button1 = new JButton("1 click = 1 dollar for animals you love");

        //here we add ActionListener
        button1.addActionListener(this);
        //'this' refer to the current object. In our case 'new Button()' from 'main'...
        //...which has implemented ActionListener.

        panel.add(button1);

        god.setVisible(true);

    }

    public static void main(String[] args){

        new Button();

    }

    //Override from Interface ActionListener and...
    //...here describe what happend when button was pressed.
    @Override
    public void actionPerformed(ActionEvent e) {

        clickCount++;

        System.out.println(clickCount);

    }


}