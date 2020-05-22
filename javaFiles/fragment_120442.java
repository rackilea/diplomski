import inet.ipaddr.AddressStringException;
import inet.ipaddr.IPAddress;
import inet.ipaddr.IPAddressString;

public class FoodApp{
    public static void main(String [] args) throws AddressStringException{  
        String ip = "2002:9876:57AB::1";
        String unCompressed = new IPAddressString(ip).toAddress().toFullString();
        System.out.println(unCompressed);
        String compressed = new IPAddressString(unCompressed).toAddress().toCompressedString();
        System.out.println(compressed);
    }
}

//2002:9876:57ab:0000:0000:0000:0000:0001
//2002:9876:57ab::1