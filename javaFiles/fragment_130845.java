public class ServerAction extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent e){
            SocketServer.startServer();
            JOptionPane.showMessageDialog(null, "Test"); 
        }
}