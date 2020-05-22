import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.net.*;
import java.io.*;

public class SUBserver {
    public static void main(String args[]) {
        try{
            InputStreamReader is = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(is);
            String portname, registryURL; 
            System.out.println("Enter port:");
            String portNum = (br.readLine()).trim();
            Subtraction exportedObj = new Subtraction();
            registryURL = "rmi://localhost:" + portNum + "/Subtract";
            Naming.rebind(registryURL, exportedObj);
            System.out.println("SUBserver ready");
        } catch (Exception re){
            System.out.println("Exception in SUBserver: " + re);
        }
    }
}