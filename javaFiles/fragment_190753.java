enter 

import java.awt.Container;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Calc extends JDialog {

private JLabel rotulo1;
private JLabel rotulo2;
private JLabel showup;
private JTextField texto1;
private JTextField texto2;
private JButton somar;
private JButton subtrair;
private JButton dividir;
private JButton multiplicar;
private JButton exibir;

public Calc(Frame owner) {
super(owner, "Calculadora");
Container tela = getContentPane();
setLayout(null);

rotulo1 = new JLabel("1 numero: ");
rotulo2 = new JLabel("2 numero: ");
showup = new JLabel("");

texto1 = new JTextField(5);
texto2 = new JTextField(5);

somar = new JButton("+");
subtrair = new JButton("-");
dividir = new JButton("/");
multiplicar = new JButton("x");
exibir = new JButton("=");

rotulo1.setBounds(30, 20, 100, 20);
rotulo2.setBounds(30, 60, 100, 20);
texto1.setBounds(100, 20, 200, 20);
texto2.setBounds(100, 60, 200, 20);
showup.setBounds(125, 100, 200, 20);
somar.setBounds(230, 100, 45, 45);// coluna, linha, largura, comprimento
subtrair.setBounds(280, 100, 45, 45);
dividir.setBounds(230, 155, 45, 45);
multiplicar.setBounds(280, 155, 45, 45);
exibir.setBounds(255, 205, 45, 45);

setVisible(true);
setLocationRelativeTo(null);

tela.add(rotulo1);
tela.add(rotulo2);
tela.add(texto1);
tela.add(texto2);
tela.add(showup);
tela.add(exibir);
tela.add(somar);
tela.add(subtrair);
tela.add(dividir);
tela.add(multiplicar);

setSize(350, 300);

somar.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        double numero1, numero2, soma;
        soma = 0;
        numero1 = Double.parseDouble(texto1.getText());
        numero2 = Double.parseDouble(texto2.getText());
        soma = numero1 + numero2;
        showup.setVisible(true);
        showup.setText(texto1.getText() + "" + "+" + "" + texto2.getText() + "" + "=" + soma);
        texto1.setText(null);
        texto2.setText(null);
        texto1.requestFocus(); // funcao limpar e focar
    }
});

subtrair.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        double numero1, numero2, subtrair;
        subtrair = 0;
        numero1 = Double.parseDouble(texto1.getText());
        numero2 = Double.parseDouble(texto2.getText());
        subtrair = numero1 - numero2;
        showup.setVisible(true);
        showup.setText(texto1.getText() + "" + "-" + "" + texto2.getText() + "" + "=" + subtrair);
        texto1.setText(null);
        texto2.setText(null);
        texto1.requestFocus();
    }
});

multiplicar.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        double numero1, numero2, multiplicar;
        multiplicar = 0;
        numero1 = Double.parseDouble(texto1.getText());
        numero2 = Double.parseDouble(texto2.getText());
        multiplicar = numero1 * numero2;
        showup.setVisible(true);
        showup.setText(texto1.getText() + "" + "x" + "" + texto2.getText() + "" + "=" + multiplicar);
        texto1.setText(null);
        texto2.setText(null);
        texto1.requestFocus();
    }
});

dividir.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        double numero1, numero2, dividir;
        dividir = 0;
        numero1 = Double.parseDouble(texto1.getText());
        numero2 = Double.parseDouble(texto2.getText());
        dividir = numero1 / numero2;
        showup.setVisible(true);
        showup.setText(texto1.getText() + "" + "/" + "" + texto2.getText() + "" + "=" + dividir);
        texto1.setText(null);
        texto2.setText(null);
        texto1.requestFocus();
    }
});

  }

}