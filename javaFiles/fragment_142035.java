import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

class ServerConnect extends JPanel implements ActionListener {
   private static final long serialVersionUID = 1L;
   private JTextField m_serverIP;
   private JTextField m_serverPort; // you can use also JPasswordField
   private JButton m_submitButton;

   // location of the jframe
   private final int m_centerX = 500;
   private final int m_centerY = 300;

   // dimensions of the jframe
   private final int m_sizeX = 1650;
   private final int m_sizeY = 150;

   ServerConnect() {
      m_serverIP = new JTextField(20);
      m_serverPort = new JTextField(20);

      JPanel gui = new JPanel(new BorderLayout(3, 3));
      gui.setBorder(new EmptyBorder(5, 5, 5, 5));
      gui.setSize(m_sizeX, m_sizeY);
      setLayout(new BorderLayout()); // !!
      add(gui, BorderLayout.CENTER);

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
      this.setLocation(m_centerX, m_centerY);
      this.setSize(m_sizeX, m_sizeY);
      // !! this.pack();
      // !! this.setVisible(true);
   }

   public static void main(String[] args) {
      new ServerConnect();
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

         // !! this.setVisible(false);
         // !! new ServerGUI(ip , s_port);
         // !!
         Window ownerWindow = SwingUtilities.getWindowAncestor(this);
         ownerWindow.dispose();
      }
   }

   // !!
   public String getServerIp() {
      return m_serverIP.getText();
   }

   // !!
   public String getServerPort() {
      return m_serverPort.getText();
   }
}