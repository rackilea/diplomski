import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Copy {

    /**
     * @param args
     */
    public static void main(String[] args) {

        JFrame ramme = new JFrame("Valutakalkulator");
        ramme.setResizable(true);
        ramme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramme.setBounds(200, 300, 400, 200);
        Container panel = ramme.getContentPane();
        panel.setLayout(new GridLayout(4,1,10,10));

        String[] Valutavalg = { "USD","NOK","EUR" };        

        final JComboBox<?> Valutavalg1 = new JComboBox<Object>(Valutavalg);
        final JComboBox<?> Valutavalg2 = new JComboBox<Object>(Valutavalg);

        final JTextField konvleft = new JTextField("0");
        final JTextField konvright = new JTextField("0");
        final JTextField utbytte = new JTextField ("Utbytte av valuta");


        JButton bleft = new JButton("Konverter  -->");
        JButton bright = new JButton("<--  Konverter");

        bleft.setFont(new Font("sansserif", Font.PLAIN + Font.BOLD, 14));
        bright.setFont(new Font("sansserif", Font.PLAIN + Font.BOLD, 14));

        panel.add(Valutavalg1);
        panel.add(Valutavalg2);
        panel.add(bleft);
        panel.add(bright);
        panel.add(konvleft);
        panel.add(konvright);
        panel.add(utbytte);

        ramme.setVisible(true);



        ActionListener ValutaLeft = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {

                double numl = Double.parseDouble(konvleft.getText());
                int combovalg1 = Valutavalg1.getSelectedIndex();
                int combovalg2 = Valutavalg2.getSelectedIndex();

                if (combovalg1==0){
                    if (combovalg2==0){
                        double totaltVerdi = numl*10;
                        setTotal(totaltVerdi, utbytte);
                    }
                    if (combovalg2==1){
                        double totaltVerdi = numl*100;
                        setTotal(totaltVerdi, utbytte);
                    }
                    if (combovalg2==2){
                        double totaltVerdi = numl*1000;
                        setTotal(totaltVerdi, utbytte);
                    }   
                }
                if (combovalg1==1){
                    if (combovalg2==0){
                        double totaltVerdi = numl*1000;
                        setTotal(totaltVerdi, utbytte);
                    }
                    if (combovalg2==1){
                        double totaltVerdi = numl*100000;
                        setTotal(totaltVerdi, utbytte);
                    }
                    if (combovalg2==2){
                        double totaltVerdi = numl*1000000;
                        setTotal(totaltVerdi, utbytte);
                    }   
                }
                if (combovalg1==2){
                    if (combovalg2==0){
                        double totaltVerdi = numl*1000000;
                        setTotal(totaltVerdi, utbytte);
                    }
                    else if (combovalg2==1){
                        double totaltVerdi = numl*1000000;
                        setTotal(totaltVerdi, utbytte);
                    }
                    else if (combovalg2==2){
                        double totaltVerdi = numl*10000000;
                        setTotal(totaltVerdi, utbytte);
                    }   
                }
            };
            public void setTotal(double totaltVerdi, JTextField text){
                totaltVerdi = Math.round(totaltVerdi*100)/100.0d;
                String total1 = Double.toString(totaltVerdi);
                utbytte.setText(total1);
            }
        };

        ActionListener ValutaRight = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {

                double numl = Double.parseDouble(konvright.getText());
                int combovalg1 = Valutavalg1.getSelectedIndex();
                int combovalg2 = Valutavalg2.getSelectedIndex();

                if (combovalg2==0){
                    if (combovalg1==0){
                        double totaltVerdi = numl*10;
                        setTotal(totaltVerdi, utbytte);
                    }
                    if (combovalg1==1){
                        double totaltVerdi = numl*100;
                        setTotal(totaltVerdi, utbytte);
                    }
                    if (combovalg1==2){
                        double totaltVerdi = numl*1000;
                        setTotal(totaltVerdi, utbytte);
                    }   
                }
                if (combovalg2==1){
                    if (combovalg1==0){
                        double totaltVerdi = numl*1000;
                        setTotal(totaltVerdi, utbytte);
                    }
                    if (combovalg1==1){
                        double totaltVerdi = numl*100000;
                        setTotal(totaltVerdi, utbytte);
                    }
                    if (combovalg1==2){
                        double totaltVerdi = numl*1000000;
                        setTotal(totaltVerdi, utbytte);
                    }   
                }
                if (combovalg2==2){
                    if (combovalg1==0){
                        double totaltVerdi = numl*1000000;
                        setTotal(totaltVerdi, utbytte);
                    }
                    if (combovalg1==1){
                        double totaltVerdi = numl*1000000;
                        setTotal(totaltVerdi, utbytte);
                    }
                    if (combovalg1==2){
                        double totaltVerdi = numl*10000000;
                        setTotal(totaltVerdi, utbytte);
                    }   
                }
            };
            public void setTotal(double totaltVerdi, JTextField text){
                totaltVerdi = Math.round(totaltVerdi*100)/100.0d;
                String total1 = Double.toString(totaltVerdi);
                utbytte.setText(total1);
            }
        };
        bleft.addActionListener(ValutaLeft);
        bright.addActionListener(ValutaRight);
    }
}