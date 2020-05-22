public class Main {

        public static void main(String[] args){
            try{
                IPAddress adr1 = new IPAddress("192.168.1.0-255");
                IPAddress adr2 = new IPAddress("192.168.1.1/24");
                IPAddress adr3 = new IPAddress("1.2.3.4");
                System.out.println("adr2 matches adr1: " + adr1.hasMatchOf(adr2));
                System.out.println("adr3 matches adr1: " + adr1.hasMatchOf(adr3));
            }catch(Exception e){
                System.err.println(e.getMessage());
            }
        }
    }