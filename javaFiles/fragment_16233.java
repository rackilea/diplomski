import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.WindowConstants;

public class Final extends JFrame {

    //Crea Elementos de la interfaz
    JLabel Etiqueta = new JLabel();
    JTextField Texto = new JTextField();
    JButton Boton = new JButton();
    JLabel Etiqueta1 = new JLabel();
    JLabel Etiqueta2 = new JLabel("Banana");
    JButton Boton1 = new JButton();

    public Final() {
        super();
        // Crea la interfaz

        setVisible(true);
        setLayout(null);
        setTitle("Lectura y escritura de datos");
        setSize(380, 200);
        //Propiedades de los elementos del Frame
        // Etiqueta
        Etiqueta.setBounds(20, 50, 100, 20);
        Etiqueta.setText("Enviar un digito");
        add(Etiqueta);
        // Caja de texto
        Texto.setBounds(120, 50, 100, 20);
        add(Texto);
        // Boton
        Boton.setBounds(250, 50, 100, 20);
        Boton.setText("Enviar");
        add(Boton);
        // Etiqueta 1
        Etiqueta1.setBounds(20, 80, 100, 20);
        Etiqueta1.setText("Leer un digito");
        add(Etiqueta1);
        // Etiqueta2
        Etiqueta2.setBounds(120, 80, 100, 20);
        add(Etiqueta2);
        // Boton 1
        Boton1.setBounds(250, 80, 100, 20);
        Boton1.setText("Leer");
        add(Boton1);
        // Boton de cierre   
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    void connect(String portName) throws Exception {

        System.out.println("...");
        new SerialReader(new FakeInputStream(), Etiqueta2).execute();

//      CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
//      if (portIdentifier.isCurrentlyOwned()) {
//          System.out.println("Error: Port is currently in use");
//      } else {
//          CommPort commPort = portIdentifier.open(this.getClass().getName(), 2000);
//
//          if (commPort instanceof SerialPort) {
//              SerialPort serialPort = (SerialPort) commPort;
//              serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
//
//              InputStream in = serialPort.getInputStream();
//              OutputStream out = serialPort.getOutputStream();
//
//              new SerialReader(in, Etiqueta2).execute();
//              (new Thread(new SerialWriter(out))).start();
//
//          } else {
//              System.out.println("Error: Only serial ports are handled by this example.");
//          }
//      }
    }

    /**
     *
     */
    public static class SerialReader extends SwingWorker<Void, String> {

        private InputStream in;
        private JLabel label;

        public SerialReader(InputStream in, JLabel label) {
            this.in = in;
            this.label = label;
        }

        @Override
        protected void process(List<String> chunks) {
            String data = chunks.get(chunks.size() - 1);
            label.setText(data);
        }

        @Override
        protected Void doInBackground() throws Exception {
            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = this.in.read(buffer)) > -1) {
                String data = new String(buffer, 0, len);
                System.out.println(data);
                publish(data);
            }
            return null;
        }

        @Override
        protected void done() {
            try {
                get();
            } catch (InterruptedException | ExecutionException ex) {
                ex.printStackTrace();
            }
        }


    }

    public static void main(String[] args) {

        try {
            (new Final()).connect("COM7");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static class FakeInputStream extends InputStream {

        private Random rnd = new Random();

        @Override
        public int read() throws IOException {
            return 33 + rnd.nextInt(125-33); // Ascii characters
        }

    }
}