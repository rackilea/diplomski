public class mainLaptop 
{

public static void main(String arg) throws Exception 
{   
    //Timing out? change the IP!
    String ip="192.168.137.127";
    String Pi1Q1="Leonardo";
    String Pi1Q2="Raphael";
    String Pi2Q3="Donatello";
    String Pi2Q4="Michelangelo";
    String pass=arg[0]; // reads the argument you pass from command line or eclipse
    //pass= StreamTest.main(pass);

    Send.send(ip, Pi1Q1, pass);
    Send.send(ip, Pi1Q2, pass);
    Send.send(ip, Pi2Q3, pass);
    Send.send(ip, Pi2Q4, pass);

/*  Recv.recv(ip, Pi1Q1);
    Recv.recv(ip, Pi1Q2);
    Recv.recv(ip, Pi2Q3);
    Recv.recv(ip, Pi2Q4);*/
}
}