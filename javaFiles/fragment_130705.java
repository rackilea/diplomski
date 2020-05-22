import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.net.*;
import java.io.*;

public class ADDserver {
    public static void main(String args[]) {
        try{
            //take input the port number
            InputStreamReader is = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(is);
            String portname, registryURL; 
            System.out.println("Enter port:");
            String portNum = (br.readLine()).trim();
            //create remote object
            Addition exportedObj = new Addition();
            //generate registry url for rmi registry server
            registryURL = "rmi://localhost:" + portNum + "/Add";
            //assosiate your object with the url in rmiregistry 
            Naming.rebind(registryURL, exportedObj);
            System.out.println("ADDserver ready");
        } catch (Exception re){
            System.out.println("Exception in ADDserver: " + re);
        }
    }
}