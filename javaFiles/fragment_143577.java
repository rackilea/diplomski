import java.awt.Desktop;
import java.io.*;
import java.lang.reflect.Array;
import java.net.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class Provider implements Runnable {
   // ServerSocket providerSocket;
    Socket connection = null;
    ObjectOutputStream out;
    String ocupado = "0";
    ObjectInputStream in;
    String caminhodoarquivo;
    Provider(Socket s){this.connection=s;}
    @Override
    public void run()
    {
        try{
            out = new ObjectOutputStream(this.connection.getOutputStream());
            //out.flush();
            sendMessage(ocupado);
            in = new ObjectInputStream(connection.getInputStream());
            System.out.println("Certidão de: " + connection.getInetAddress().getHostName());
            String ocupado = "1";
                try{
                    caminhodoarquivo = (String)in.readObject();
                   System.out.println("Certidão: " + caminhodoarquivo);
                   JTextField paginainicial = new JTextField();
                   JTextField paginafinal = new JTextField();
                   Object[] message = {
                        "Número da Primeira Folha: ", paginainicial,
                        "Número Última Folha: ", paginafinal,
                    };
                int option = JOptionPane.showConfirmDialog(null, message, "Dados da Certidão", JOptionPane.OK_CANCEL_OPTION);
                ocupado = "1";
                if (option == JOptionPane.OK_OPTION) {
                    String primeirafolha = paginainicial.getText();
                    String ultimafolha = paginafinal.getText();
                    metodos metodosBD = new metodos();
                    metodosBD.atualizafolha(primeirafolha, ultimafolha, caminhodoarquivo);
                    System.out.println("Dados inseridos.");
                    Desktop.getDesktop().print(new File(caminhodoarquivo)); 
                    ocupado = "0";
                }else {System.out.println("Certidão Cancelada.");}
                }catch(ClassNotFoundException classnot){
                    System.err.println("Data received in unknown format");
                    out.close();
                    in.close();
                    connection.close();
                }
        }
        catch(IOException ioException){ioException.printStackTrace();}
        finally{
            Server.setFree();//Tells server the system is ready for new connection.
            //4: Closing connection
            try{
                in.close();
                out.close();
                connection.close();
            }
            catch(IOException ioException){
                ioException.printStackTrace();
            }
        }
    }

    void sendMessage(String msg)
    {
        try{
            out.writeObject(msg);
            out.flush();
        }
        catch(IOException ioException){
            ioException.printStackTrace();
        }
    }
//    public static void main(String args[])
//    {
//        Provider server = new Provider();
//        while(true){
//            server.run();
//        }
//    }

}