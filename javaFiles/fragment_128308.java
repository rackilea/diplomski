public class PrintApplet extends Applet {

 private static final long serialVersionUID = 1L;
 private PrintService service;

 public void init() 
 {
    JOptionPane.showMessageDialog(null, "Inside INIT()");
    if(null==service){
        service = PrintServiceLookup.lookupDefaultPrintService();
        System.out.println(service.getName());
    } else {
        System.out.println(service.getName());
    }
 }
 public void print(String str) throws PrintException 
 {
    JOptionPane.showMessageDialog(null, "Inside print()");
    JOptionPane.showMessageDialog(null, "String is:::"+str);
    cPrint cP = new cPrint(str, service);
    System.out.println((Integer) AccessController.doPrivileged(cP));
 }
}