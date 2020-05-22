import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.*;

public class Foo3b extends JPanel {
   public static final int CEDULA_TAMANIO_CORRECTO1 = 10;
   public static final int CEDULA_TAMANIO_CORRECTO2 = 13;
   public static final Color COLOR_INCORRECTO = Color.RED;
   public static final Color COLOR_CORRECTO = Color.BLUE;
   public static final int NOMBRE_TAMANIO_MIN = 8;
   public static final int NOMBRE_TAMANIO_MAX = 24;
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

      cedulaField.setInputVerifier(new CedulaVerifier());

      nombreField.setInputVerifier(new NombreVerifier());
   }

   private class CedulaVerifier extends InputVerifier {
      private String texto = "";
      private int tamanio = 0;

      @Override
      public boolean verify(JComponent input) {
         texto = ((JTextField) input).getText().trim();
         tamanio = texto.length();

         if (texto.isEmpty()) {
            return false;
         } else if (tamanio != CEDULA_TAMANIO_CORRECTO1
               && tamanio != CEDULA_TAMANIO_CORRECTO2) {
            return false;
         }
         // default
         return true;
      }

      @Override
      public boolean shouldYieldFocus(JComponent input) {
         texto = ((JTextField) input).getText().trim();
         tamanio = texto.length();
         if (verify(input)) {
            mensajeLabel.setForeground(COLOR_CORRECTO);
            if (tamanio == CEDULA_TAMANIO_CORRECTO1) {
               mensajeLabel.setText("Cedula Correcta");
            } else if (tamanio == CEDULA_TAMANIO_CORRECTO2) {
               mensajeLabel.setText("R.U.C Correcto");
            }

            return true;
         } else {
            mensajeLabel.setForeground(COLOR_INCORRECTO);

            if (texto.isEmpty()) {
               mensajeLabel.setText("Cedula Vacio");
            } else if (tamanio > 0 && tamanio < 9) {
               mensajeLabel.setText("Cedula Incorrecta");
            } else if (tamanio > 11 && tamanio < 13) {
               mensajeLabel.setText("RUC Incorrecto");
            } else if (tamanio > 13) {
               mensajeLabel.setText("R.U.C INcorrecto");
            }
         }
         return false;
      }

   }

   private class NombreVerifier extends InputVerifier {
      private String texto = "";
      private int tamanio = 0;

      @Override
      public boolean verify(JComponent input) {
         texto = ((JTextField) input).getText().trim();
         tamanio = texto.length();

         if (texto.isEmpty()) {
            return false;
         } else if (tamanio < NOMBRE_TAMANIO_MIN
               || tamanio > NOMBRE_TAMANIO_MAX) {
            return false;
         }
         // default
         return true;

      }

      @Override
      public boolean shouldYieldFocus(JComponent input) {
         texto = ((JTextField) input).getText().trim();
         tamanio = texto.length();
         if (verify(input)) {
            mensajeLabel.setForeground(COLOR_CORRECTO);
            mensajeLabel.setText("Nombre Correcto");            
            return true;
         } else {
            mensajeLabel.setForeground(COLOR_INCORRECTO);
            if (texto.isEmpty()) {
               mensajeLabel.setText("Nombre Vacio");
            } else if (tamanio < NOMBRE_TAMANIO_MIN) {
               mensajeLabel.setText("Debe Ingresar 2 Nombres");
            } else if (tamanio > NOMBRE_TAMANIO_MAX) {
               mensajeLabel.setText("Nombre Incorrecto");
            }            
            return false;
         }
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