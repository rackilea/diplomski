import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Carl extends JFrame{
    JTextField text1= new JTextField ();
    JLabel label1= new JLabel (" ");
    JButton button1= new JButton ("1");
    JButton button2= new JButton ("2");
    JButton button3= new JButton ("3");
    JButton button4= new JButton ("4");
    JButton button5= new JButton ("5");
    JButton button6= new JButton ("6");
    JButton button7= new JButton ("7");
    JButton button8= new JButton ("8");
    JButton button9= new JButton ("9");
    JButton button10= new JButton ("0");
    JButton button11= new JButton ("+");
    JButton button12= new JButton ("-");
    JButton button13= new JButton ("*");
    JButton button14= new JButton ("/");
    JButton button15= new JButton ("=");
    JButton button16= new JButton ("C");
    JLabel blank1 = new JLabel("");
    JLabel blank2 = new JLabel("");
    JLabel blank3 = new JLabel("");
    JLabel blank4 = new JLabel(""); 
    Font times= new Font ("Times New Roman", Font.BOLD, 14);
    int operation1;
    int operation2;
    int operation3;
    int operation4;
    String n1,n2;
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();

public Carl(){
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Calculator");
        setSize(600,600);           
        button1.setForeground(Color.BLACK);
        button2.setForeground(Color.BLACK);
        button3.setForeground(Color.BLACK);
        button4.setForeground(Color.BLACK);
        button5.setForeground(Color.BLACK);
        button6.setForeground(Color.BLACK);
        button7.setForeground(Color.BLACK);
        button8.setForeground(Color.BLACK);
        button9.setForeground(Color.BLACK);
        button10.setForeground(Color.BLACK);
        button11.setForeground(Color.BLACK);
        button12.setForeground(Color.BLACK);
        button13.setForeground(Color.BLACK);
        button14.setForeground(Color.BLACK);
        button15.setForeground(Color.BLACK);
        button16.setForeground(Color.BLACK);
        button1.setBackground(Color.YELLOW);
        button2.setBackground(Color.YELLOW);
        button3.setBackground(Color.YELLOW);
        button4.setBackground(Color.YELLOW);
        button5.setBackground(Color.YELLOW);
        button6.setBackground(Color.YELLOW);
        button7.setBackground(Color.YELLOW);
        button8.setBackground(Color.YELLOW);
        button9.setBackground(Color.YELLOW);
        button10.setBackground(Color.YELLOW);
        button11.setBackground(Color.YELLOW);
        button12.setBackground(Color.YELLOW);
        button13.setBackground(Color.YELLOW);
        button14.setBackground(Color.YELLOW);
        button15.setBackground(Color.YELLOW);
        button16.setBackground(Color.YELLOW);
        button1.setToolTipText ("one");
        button2.setToolTipText ("two");
        button3.setToolTipText ("three");
        button4.setToolTipText ("four");
        button5.setToolTipText ("five");
        button6.setToolTipText ("six");
        button7.setToolTipText ("seven");
        button8.setToolTipText ("eight");
        button9.setToolTipText ("nine");
        button10.setToolTipText ("zero");
        button11.setToolTipText ("addition");
        button12.setToolTipText ("subtraction");
        button13.setToolTipText ("multiplication");
        button14.setToolTipText ("division");
        button15.setToolTipText ("equal");
        button16.setToolTipText ("clear");
        button1.setFont(times);
        button2.setFont(times);
        button3.setFont(times);
        button4.setFont(times);
        button5.setFont(times);
        button6.setFont(times);
        button7.setFont(times);
        button8.setFont(times);
        button9.setFont(times);
        button10.setFont(times);
        button11.setFont(times);
        button12.setFont(times);
        button13.setFont(times);
        button14.setFont(times);
        button15.setFont(times);
        button16.setFont(times);
        label1.setFont(times);
        setLayout(new BorderLayout());
        p1.setLayout(new GridLayout(6,3,2,2));
        p1.add(p2,BorderLayout.CENTER);
        p1.add(label1);
        p1.add(text1);
        p1.add(blank3);
        p1.add(button7);
        p1.add(button8);
        p1.add(button9);
        p1.add(button11);
        p1.add(button4);
        p1.add(button5);
        p1.add(button6);
        p1.add(button12);
        p1.add(button1);
        p1.add(button2);
        p1.add(button3);
        p1.add(button13);
        p1.add(button10);
        p1.add(button16);
        p1.add(button15);
        p1.add(button14);
add(p1,BorderLayout.CENTER);

button1.addActionListener(new Listener1());
        button2.addActionListener(new Listener2());
        button3.addActionListener(new Listener3());
        button4.addActionListener(new Listener4());
        button5.addActionListener(new Listener5());
        button6.addActionListener(new Listener6());
        button7.addActionListener(new Listener7());
        button8.addActionListener(new Listener8());
        button9.addActionListener(new Listener9());
        button10.addActionListener(new Listener0());
        button11.addActionListener(new ListenerAdd());
        button12.addActionListener(new ListenerSub());
        button13.addActionListener(new ListenerMul());
        button14.addActionListener(new ListenerDiv());
        button15.addActionListener(new ListenerEqual());
        button16.addActionListener(new ListenerClear());
setVisible(true);

}

    private class Listener1 implements ActionListener{
        public void actionPerformed (ActionEvent a){
            n1= text1.getText ();                   
            text1.setText (n1+"1");
        }
    }


private class Listener2 implements ActionListener{
        public void actionPerformed (ActionEvent b){
            n1= text1.getText ();
            text1.setText (n1+"2");
        }
    }   
    private class Listener3 implements ActionListener{
        public void actionPerformed (ActionEvent c){
            n1= text1.getText ();
            text1.setText (n1+"3");
        }
    }   
    private class Listener4 implements ActionListener{
        public void actionPerformed (ActionEvent d){
            n1= text1.getText ();
            text1.setText (n1+"4");
        }
    }   
    private class Listener5 implements ActionListener{
        public void actionPerformed (ActionEvent e){
            n1= text1.getText ();
            text1.setText (n1+"5");
        }
    }   

private class Listener6 implements ActionListener{
        public void actionPerformed (ActionEvent f){
            n1= text1.getText ();
            text1.setText (n1+"6");
        }
    }   
    private class Listener7 implements ActionListener{
        public void actionPerformed (ActionEvent g){
            n1= text1.getText ();
            text1.setText (n1+"7");
        }
    }   
    private class Listener8 implements ActionListener{
        public void actionPerformed (ActionEvent h){
            n1= text1.getText ();
            text1.setText (n1+"8");
        }
    }   
    private class Listener9 implements ActionListener{
        public void actionPerformed (ActionEvent i){
            n1= text1.getText ();
            text1.setText (n1+"9");
        }
    }

private class Listener0 implements ActionListener{
        public void actionPerformed (ActionEvent j){
            n1= text1.getText ();
            text1.setText (n1+"0");
        }
    }
    private class ListenerAdd implements ActionListener{
        public void actionPerformed (ActionEvent k){
            n2= text1.getText ();
            operation1=1;
            text1.setText ("");
        }
    }   
    private class ListenerSub implements ActionListener{
        public void actionPerformed (ActionEvent l){
            n2= text1.getText ();
            operation2=2;
            text1.setText ("");
        }
    }

private class ListenerMul implements ActionListener{
        public void actionPerformed (ActionEvent m){
            n2= text1.getText ();
            operation3=3;
            text1.setText ("");
        }
    }

    private class ListenerDiv implements ActionListener{
        public void actionPerformed (ActionEvent n){
            n2= text1.getText ();
            operation4=4;
            text1.setText ("");         
        }
    }
    private class ListenerEqual implements ActionListener{
        public void actionPerformed (ActionEvent o){
            if(operation1==1){
                int a=Integer.parseInt(n2);
                int b=Integer.parseInt(text1.getText());
                int sum = (a + b);  
                String sum1 = Integer.toString(sum);
                text1.setText(sum1);
            }

else{
            text1.getText();
            }
            if(operation2==2){
                int a=Integer.parseInt(n2);
                int b=Integer.parseInt(text1.getText());
                int dif = (a - b);
                String dif1 = Integer.toString(dif);
                text1.setText(dif1);
            }
            else{
            text1.getText();
            }
            if(operation3==3){
                int a=Integer.parseInt(n2);
                int b=Integer.parseInt(text1.getText());
                int product = (a * b);  
                String product1 = Integer.toString(product);
                text1.setText(product1); 
            }

else{
            text1.getText();
            }
            if(operation4==4){
                double a=Double.parseDouble(n2);
                double b=Double.parseDouble(text1.getText());
                double quo = (a/b); 
                String quo1 = Double.toString(quo);
                text1.setText(quo1); 
            }
            else{
            text1.getText();
            }       
        }
    }   
    private class ListenerClear implements ActionListener{
        public void actionPerformed (ActionEvent p){
            text1.setText("");
        }
    }   
public static void main(String[]args){
    Carl frame= new Carl();     
}
}