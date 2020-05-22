import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import javax.swing.*;
import java.awt.event.*;

public class Lista extends JFrame{
  public Lista(){
    super("Menu");

    // Menu Bar
    JMenuBar barra = new JMenuBar();
    setJMenuBar(barra);

    // Menu
    JMenu opcoes = new JMenu("Options");

    // Menu Item
    JMenuItem item = new JMenuItem("Item 1");

    // actionlistener
    item.addActionListener(
      new ActionListener(){
        public void actionPerformed(ActionEvent e){
          new Calc(Lista.this);
        }
      }
    );

    opcoes.add(item);

    // Adds
    barra.add(opcoes);

    setSize(300, 150);
    setVisible(true);    
  }

  public static void main(String args[]){
    Lista app = new Lista();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}