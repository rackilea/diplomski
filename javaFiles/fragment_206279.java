public class EplPrint1 {
            private final String port;
            public EplPrint1(String port) {
                    this.port = port;
            }
            public void printLabel(String label, String company, String docDate) throws FileNotFoundException {
                    FileOutputStream os = new FileOutputStream(port);
                    PrintStream ps = new PrintStream(os);
                    String commands = "N\n"
                            +  "A1,1,0,1,1,1,N,\""+asciiNormalize(company)+"\"\n"
                            + "A1,20,0,1,1,1,N,\""+asciiNormalize("Entry date")+": " + docDate+"\"\n"
                            + "B1,40,0,1,3,2,80,B,\""+label+"\"\n"
                            + "P1,1\n";     

                    ps.println(commands);
                    ps.print("\f");
                    ps.close();
            }

            public static void main(String[] argv) throws FileNotFoundException {
                    //EplPrint1 p = new EplPrint1("d:\\tmp\\eplcommands.txt");
                    EplPrint1 p = new EplPrint1("LPT1");
                    //p.printLabel("23535.A.33.B.233445");  
                    p.printLabel("label 12345", "Company name", "2013-05-10 12:45");
            }
    }