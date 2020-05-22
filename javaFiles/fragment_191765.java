import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.*;

public class Foo3b extends JPanel {
   private String texto;
   private int tamanio;
   private JTextField cedulaField = new JTextField(10);
   private JTextField nombreField = new JTextField(10);
   private JLabel mensajeLabel = new JLabel(" ");

   public Foo3b() {
      JPanel panel = new JPanel();
      panel.add(new JLabel("Cedula:"));
      panel.add(cedulaField);
      panel.add(new JLabel("Nombre:"));
      panel.add(nombreField);

      JPanel mensajePanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
      mensajePanel.add(new JLabel("Mensaje:"));
      mensajePanel.add(mensajeLabel);

      setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
      add(panel);
      add(mensajePanel);

      cedulaField.addFocusListener(new FocusAdapter() {
         @Override
         public void focusLost(FocusEvent e) {
            validarCedula(cedulaField, mensajeLabel);
         }
      });

      nombreField.addFocusListener(new FocusAdapter() {
         @Override
         public void focusLost(FocusEvent e) {
            validarNombre(nombreField, mensajeLabel);
         }
      });
   }

   public void validarCedula(JTextField txt, JLabel lblMensaje) {
      System.out.println("Dentro do validarCedula");
      texto = txt.getText().trim();
      tamanio = texto.length();
      lblMensaje.setText("");        
      try{
      if (texto.isEmpty()) 
      {
          lblMensaje.setText("Cedula Vacio");
          lblMensaje.setForeground(Color.red);
          txt.requestFocus();
      }
      else if (tamanio > 0 && tamanio < 9) {
          lblMensaje.setText("Cedula Incorrecta");
          lblMensaje.setForeground(Color.red);
          txt.requestFocus();
      } else if (tamanio == 10) {
          lblMensaje.setText("Cedula Correcta");
          lblMensaje.setForeground(Color.white);
      } else if (tamanio > 11 && tamanio < 13) {
          lblMensaje.setText("RUC Incorrecto");
          lblMensaje.setForeground(Color.red);
          txt.requestFocus();
      } else if (tamanio == 13) {
          lblMensaje.setText("R.U.C Correcto");
          lblMensaje.setForeground(Color.WHITE);
      }
      }catch(Exception ex)
      {
          JOptionPane.showMessageDialog(null, ex);
      }
  }


  public void validarNombre(JTextField txt, JLabel lblMensaje) {
     System.out.println("Dentro do validarNombre");
      texto = txt.getText().trim();
      tamanio = texto.length();   
      try{
      if (texto.isEmpty()) 
      {
          lblMensaje.setText("Nombre Vacio");
          lblMensaje.setForeground(Color.red);
          txt.requestFocus();
      }
      else if (tamanio > 0 && tamanio < 7) {
              lblMensaje.setText("Debe Ingresar 2 Nombres");
              lblMensaje.setForeground(Color.red);
              txt.requestFocus();
          } else if (tamanio > 7 && tamanio < 24) {
              lblMensaje.setText("Nombre Correcto");
              lblMensaje.setForeground(Color.WHITE);
          } else if (tamanio > 25) {
              lblMensaje.setText("Nombre Incorrecto");
              lblMensaje.setForeground(Color.red);
              txt.requestFocus();
          }
      }catch(Exception ex)
      {
          JOptionPane.showMessageDialog(null, ex);
      }
  }

  private static void createAndShowGui() {
     Foo3b mainPanel = new Foo3b();

     JFrame frame = new JFrame("Foo3");
     frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
     frame.getContentPane().add(mainPanel);
     frame.pack();
     frame.setLocationByPlatform(true);
     frame.setVisible(true);
  }

  public static void main(String[] args) {
     SwingUtilities.invokeLater(new Runnable() {
        public void run() {
           createAndShowGui();
        }
     });
  }


}