import javax.comm.*;
import java.util.Enumeration;

public class ListPorts {
public static void main(String args[]) {
Enumeration ports = CommPortIdentifier.getPortIdentifiers();
while (ports.hasMoreElements()) {
CommPortIdentifier port = (CommPortIdentifier)ports.nextElement();
String type;
switch (port.getPortType()) {
case CommPortIdentifier.PORT_SERIAL:
type = "Serial"; 
break;
default: /// Shouldn't happen
type = "Unknown"; 
break;
}
System.out.println(port.getName() + ": " + type);
}
}
}