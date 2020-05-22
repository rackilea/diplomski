public class MyClient {

    public static void main(String[] args) {

        InetAddress ip;
        try {
            long diskSize = new File("C:").getTotalSpace() + new File("D:").getTotalSpace() + new File("E:").getTotalSpace();
            long memorySize = ((com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean()).getTotalPhysicalMemorySize();
            ip = InetAddress.getLocalHost();
            Socket s = new Socket("localhost", 6666);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            dout.writeUTF(ip.getHostName());
            dout.writeUTF(ip.getHostAddress());
            dout.writeUTF(System.getProperty("os.name"));
            dout.writeUTF(System.getProperty("os.arch"));
            dout.writeUTF(System.getProperty("os.version"));
//            dout.writeUTF(System.getenv("processor_identifier"));
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            StringBuilder sb = new StringBuilder();
            byte[] mac = network.getHardwareAddress();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            dout.writeUTF(sb.toString());
            dout.writeLong(diskSize);
            dout.writeLong(memorySize);
            dout.flush();
            dout.close();
            s.close();
        } catch (Exception ex) {
            System.out.println("Client");
            System.out.println(ex);
        }
    }
}