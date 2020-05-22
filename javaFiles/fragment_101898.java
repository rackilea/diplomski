import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MathPanel extends JFrame {

    public static double sqrt(double d) {
        return Math.sqrt(d);
    }

    public static double sin(double d) {
        return Math.sin(d);
    }

    public static double cos(double d) {
        return Math.cos(d);
    }

    class Item implements ActionListener {
        JTextField result = new JTextField();
        JTextField param = new JTextField();
        JButton button;
        Method m;
        public Item(JFrame frame,String name, Method m) {
            button = new JButton(name);
            button.addActionListener(this);
            this.m = m;
            frame.getContentPane().add(param);
            frame.getContentPane().add(button);
            frame.getContentPane().add(result);
        }

        public void actionPerformed(ActionEvent e) {
            String cmd  = e.getActionCommand();
            Item item = map.get(cmd);
            try {
                double dbl = Double.parseDouble(item.param.getText());
                Object invoke = item.m.invoke(this, dbl);
                item.result.setText("" + invoke );
            } 
            catch (Exception x) {
                x.printStackTrace();
            }
        }
    }

    HashMap<String,Item>map = new HashMap<String, Item>(); 


    public MathPanel() {
        setLayout(new GridLayout(3,3));
        setTitle("Test");
        setSize(400, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void init() {
        try {
            Method[] allMethods = MathPanel.class.getDeclaredMethods();
            for (Method m : allMethods) {
                String mname = m.getName();
                Class<?> returnType = m.getReturnType();
                if ( returnType.getName().equals("double")) {
                    Item item = new Item(this,mname,m);
                    map.put(mname,item);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MathPanel mp = new MathPanel();
        mp.init();
    }
}