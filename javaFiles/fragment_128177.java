import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.InetAddress;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.SwingPropertyChangeSupport;

public class ServerController {

   String m_ip;
   int m_port;
   private static String[] ipPort;

   public static void main(String args[]) {
      final ServerConnector sc = new ServerConnector();

      sc.addPropertyChangeListener(new PropertyChangeListener() {
         @Override
         public void propertyChange(PropertyChangeEvent evt) {
            if (ServerConnector.READY.equals(evt.getPropertyName())) {
               if (sc.isReady()) {
                  ipPort = sc.getIPandPort();
                  System.out.println("IP is :" + ipPort[0] + " and port is :" + ipPort[1]);
               }
            }
         }
      });
   }
}

class ServerConnector implements ActionListener {
   public static final String READY = "ready"; //!!

   private SwingPropertyChangeSupport pcSupport = new SwingPropertyChangeSupport(this); //!!
   private boolean ready = false;
   private JFrame m_frame = null;
   private JTextField m_serverIP;
   private JTextField m_serverPort; // you can use also JPasswordField
   private JButton m_submitButton;

   // location of the jframe
   private final int m_centerX = 500;
   private final int m_centerY = 300;

   // dimensions of the jframe
   private final int m_sizeX = 1650;
   private final int m_sizeY = 150;

   private String m_ip;
   private String m_port;


   /**
    * Ctor
    */
   ServerConnector() {
      m_frame = new JFrame("Sever Side Listener");
      m_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      m_serverIP = new JTextField(20);
      m_serverPort = new JTextField(20);

      JPanel gui = new JPanel(new BorderLayout(3, 3));
      gui.setBorder(new EmptyBorder(5, 5, 5, 5));
      gui.setSize(m_sizeX, m_sizeY);
      m_frame.setContentPane(gui);

      JPanel labels = new JPanel(new GridLayout(0, 1));
      JPanel controls = new JPanel(new GridLayout(0, 1));
      gui.add(labels, BorderLayout.WEST);
      gui.add(controls, BorderLayout.CENTER);

      labels.add(new JLabel("Server IP: "));
      controls.add(m_serverIP);
      labels.add(new JLabel("Server Port: "));
      controls.add(m_serverPort);
      m_submitButton = new JButton("Start Listening");
      m_submitButton.addActionListener(this);

      gui.add(m_submitButton, BorderLayout.SOUTH);
      m_frame.setLocation(m_centerX, m_centerY);
      m_frame.setSize(m_sizeX, m_sizeY);
      m_frame.pack();
      m_frame.setVisible(true);
   }

   public static void main(String[] args) {
      new ServerConnector();
   }

   @Override
   public void actionPerformed(ActionEvent event) {

      Object object = event.getSource();
      if (object == this.m_submitButton) {
         // grab all values from the connection box
         // if one of them is missing then display an alert message

         String ip = this.m_serverIP.getText().trim();
         String port = this.m_serverPort.getText().trim();

         if (ip.length() == 0) {
            JOptionPane.showMessageDialog(null, "Please enter IP address !");
            return;
         }

         if (port.length() == 0) {
            JOptionPane.showMessageDialog(null, "Please enter Port number!");
            return;
         }

         int s_port = 0;

         try {
            // try parse the Port number
            // throws exception when an incorrect IP address
            // is entered , and caught in the catch block
            s_port = Integer.parseInt(port);
         }

         catch (Exception exp) {
            JOptionPane.showMessageDialog(null, "Port number is incorrect!");
            return;
         }

         try {
            // try parse the IP address
            // throws exception when an incorrect IP address
            // is entered , and caught in the catch block
            InetAddress.getByName(ip);
         }

         catch (Exception exp) {
            JOptionPane.showMessageDialog(null, "IP address is incorrect!");
            return;
         }

         m_frame.dispose();
         this.m_ip = ip;
         this.m_port = port;
         setReady(true); //!!
         // !! ready = true;
         // new ServerGUI(ip , s_port);
      }

   }

   // !! added
   public void setReady(boolean ready) {
      boolean oldValue = this.ready;
      boolean newValue = ready;
      this.ready = ready;
      pcSupport.firePropertyChange(READY, oldValue, newValue);
   }

   //!! added
   public void addPropertyChangeListener(PropertyChangeListener listener) {
      pcSupport.addPropertyChangeListener(listener);
   }

   //!! added
   public void removePropertyChangeListener(PropertyChangeListener listener) {
      pcSupport.removePropertyChangeListener(listener);
   }

   public boolean isReady() {
      return this.ready;
   }

   /**
    * 
    * @return
    */
   public String[] getIPandPort() {
      String[] ipPort = new String[2];
      ipPort[0] = this.m_ip;
      ipPort[1] = this.m_port;
      return ipPort;
   }
}