package stackoverflow;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * This is pktanalyzer class which is a packet analyzer.
 * 
 * @author Shailesh Vajpayee (srv6224@rit.edu)
 *
 */
public class Pktanalyzer {

    private int current_start_index;
    private int IP_header_length;
    private int TCP_header_length;
    private long size_of_data;

    private static final String HEADER = "\t === PACKET ANALYZER === \n";
    /**
     * Constructor of the class pktanalyzer
     */
    public Pktanalyzer() {
        // print_hex(byte_stream);
        setCurrent_start_index(0);
    }

    /**
     * This function reads the binary file and stores it in a byte array
     * 
     * @param filename
     *            The name of the file to be read
     */
    public byte[] readFile(String filename) throws IOException{
        return readFile(new File(filename));
    }

    public byte[] readFile(File file)  throws IOException{
        final Path bin_path = file.toPath();
        byte[] obyte_stream = null;

        try {
            obyte_stream = Files.readAllBytes(bin_path);
        } catch (IOException e) {
            throw e;
        }

        return obyte_stream;
    }

    /**
     * This function is used to print the file.
     * 
     * @param b
     *            the byte array to be printed
     */
    public static void print_hex(byte[] b) {
        // sb.append("\nLength of byte array is " + b.length);
        // size_of_packet = b.length;
        //System.out.print(DatatypeConverter.printHexBinary(b));

        for (int i = 0; i < b.length; i++) {
            System.out.print(String.format("%02x", b[i]));

        }
        // sb.append("\n");
    }

    /**
     * This function parses the Ethernet Header and analyzes its sub parts
     * 
     * @param b
     *            The byte array
     * @param begin_index
     *            The beginning index for this header
     * @return End index
     */
    public String Ether_packet_parser(byte[] b) {
        int index = 0;
        final StringBuilder sb = new StringBuilder();
        sb.append(HEADER);

        sb.append("\n      Packet Size: " + b.length + " bytes\n");
        sb.append("ETHER: ----- Ether Header ----- (14 bytes)\n");
        sb.append("ETHER: Destination address: ");
        for (int i = 0; i < 6; i++) {
            if (i != 5)
                sb.append(String.format("%02x", b[index]) + ":");
            else
                sb.append(String.format("%02x", b[index]) + "");
            index++;
        }
        sb.append("\n");
        sb.append("ETHER: Source address: ");
        for (int i = 0; i < 6; i++) {
            if (i != 5)
                sb.append(String.format("%02x", b[index]) + ":");
            else
                sb.append(String.format("%02x", b[index]) + "");
            index++;
        }
        sb.append("\nETHER: Ethertype: ");
        sb.append(String.format("%02x", b[index]) + "" + String.format("%02x", b[index + 1]));
        sb.append("\n ||||||||||||||||||||||||||||");

        String parsedString = "\n\n---DONE---";

        if ((String.format("%02x", b[index]) + "" + String.format("%02x", b[index + 1])).equals("0800")) {
            index += 2;
            parsedString = IP_packet_parser(b, index);
        }

        sb.append(parsedString);

        return sb.toString();
    }

    /**
     * This function parses the IP Header and analyzes its sub parts
     * 
     * @param b
     *            The byte array
     * @param begin_index
     *            The beginning index for this header
     * @return The end index
     */
    private String IP_packet_parser(byte[] b, int begin_index) {
        int index = begin_index;
        final StringBuilder sb = new StringBuilder();
        sb.append("\nIP:    ----- IP Header -----(20 bytes)");
        sb.append("\nIP: Version(4 bits): " + String.format("%01x", (b[index] >>> 4)));
        int header_length = (b[index] & 0x0F) * 4;
        IP_header_length = header_length;
        sb.append("\nIP: Internet Header Length(IHL)(4 bits): " + header_length + " bytes");
        index++;
        sb.append("\nIP: Type of Service(8 bits): 0x" + String.format("%02x", b[index]));
        sb.append("\nIP:\t xxx. .... : precedence");
        String flag = "";
        flag += "..." + String.format("%01x", (b[index] >>> 4) & 1) + " ....";
        if (flag.equals("...0 ....")) {
            sb.append("\nIP:\t " + flag + " : normal delay");
        } else {
            sb.append("\nIP:\t " + flag + " : low delay");
        }
        flag = "";
        flag += ".... " + String.format("%01x", (b[index] >>> 3) & 1) + "...";
        if (flag.equals(".... 0...")) {
            sb.append("\nIP:\t " + flag + " : normal throughput");
        } else {
            sb.append("\nIP:\t " + flag + " : high throughput");
        }
        flag = "";
        flag += ".... ." + String.format("%01x", (b[index] >>> 3) & 1) + "..";
        if (flag.equals(".... .0..")) {
            sb.append("\nIP:\t " + flag + " : normal reliability");
        } else {
            sb.append("\nIP:\t " + flag + " : high reliability");
        }

        index++;
        long total_length = b[index] << 8 | b[index + 1] & 0xFF;
        index += 2;
        sb.append("\nIP: Total Length(16 bits): " + total_length + " bytes\n");
        long identification = (b[index] << 8 | b[index + 1]) & 0xFFFF;
        index += 2;
        sb.append("IP: Identification(16 bits): " + Long.parseLong(String.format("%04x", identification & 0xFFFF), 16));
        sb.append("\nIP: Flags(3 bits): 0x" + String.format("%02x", (b[index] >>> 5)));
        flag = "";
        flag = "." + String.format("%01x", (b[index] >>> 6) & 1) + ".";
        if (flag.equals(".1.")) {
            sb.append("\nIP:\t" + flag + ". .... : do not fragment");
        } else
            sb.append("\nIP:\t" + flag + ". .... : fragment");
        flag = "";
        flag = ".." + String.format("%01x", (b[index] >>> 5) & 1) + "";
        if (flag.equals("..1")) {
            sb.append("\nIP:\t" + flag + ". .... : more fragments");
        } else
            sb.append("\nIP:\t" + flag + ". .... : last fragment");
        sb.append("\nIP: Fragment offset(13 bits): 0x" + String.format("%02x", ((b[index] & 0x1F) + b[index + 1])));
        index += 2;
        sb.append(
                "\nIP: Time to Live(8 bits): " + Long.parseLong(String.format("%02x", b[index]), 16) + " seconds/hops");
        index++;
        int protocol = Integer.parseInt(Integer.toHexString(b[index]));
        if (protocol == 6) {
            sb.append("\nIP: Protocol(8 bits): TCP (" + protocol + ")");
        } else if (protocol == 11) {
            sb.append("\nIP: Protocol(8 bits): UDP (" + protocol + ")");
        } else if (protocol == 1) {
            sb.append("\nIP: Protocol(8 bits): ICMP (" + protocol + ")");
        }
        index++;
        int chksum = (b[index] << 8 | b[index + 1] & 0xFF);
        index += 2;
        sb.append("\nIP: Header Checksum(16 bits): 0x" + String.format("%04x", chksum & 0xFFFF));
        sb.append("\nIP: Source address(32 bits): ");
        String IP = "";
        for (int i = 0; i < 4; i++) {
            if (i != 3) {
                IP += (b[index] & 255) + ".";
            } else {
                IP += (b[index] & 255);
            }
            index++;
        }
        sb.append(IP);
        InetAddress ad;
        try {
            ad = InetAddress.getByName(IP);
            String host = ad.getHostName();
            sb.append("  '" + host + "'");
        } catch (UnknownHostException e) {
            // e.printStackTrace();
        }
        IP = "";
        sb.append("\nIP: Destination address(32 bits): ");
        for (int i = 0; i < 4; i++) {
            if (i != 3) {
                IP += (b[index] & 255) + ".";
            } else {
                IP += (b[index] & 255);
            }
            index++;
        }
        sb.append(IP);
        try {
            ad = InetAddress.getByName(IP);
            String host = ad.getHostName();
            sb.append("  '" + host + "'");
        } catch (UnknownHostException e) {
            // e.printStackTrace();
        }
        if (index == begin_index + header_length)
            if (header_length / 4 <= 5)
                sb.append("\nIP: No Options");
            else {
                sb.append("\nIP: Options found : " + (header_length - 20));
                index = index + (header_length - 20);
            }

        sb.append("\n ||||||||||||||||||||||||||||");

        String parsedString = "NO DATA";

        if (protocol == 1) {
            parsedString = ICMP_packet_parser(b, index);
        } else if (protocol == 6) {
            parsedString = TCP_packet_parser(b, index);
        } else if (protocol == 11) {
            parsedString = UDP_packet_parser(b, index);
        }

        sb.append(parsedString);

        return sb.toString();
    }

    /**
     * This function parses the TCP Header and analyzes its sub parts
     * 
     * @param b
     *            The byte array
     * @param begin_index
     *            The beginning index for this header
     */
    private String TCP_packet_parser(byte[] b, int begin_index) {
        final StringBuilder sb = new StringBuilder();
        int index = begin_index;
        sb.append("\nTCP:   ----- TCP Header -----");
        String part1 = String.format("%02x", b[index]);
        String part2 = String.format("%02x", b[index + 1]);
        String hex = part1 + part2;
        sb.append("\nTCP: Source Port(16 bits): " + Long.parseLong(hex, 16));
        index += 2;
        part1 = String.format("%02x", b[index]);
        part2 = String.format("%02x", b[index + 1]);
        hex = part1 + part2;
        index += 2;
        sb.append("\nTCP: Destination Port(16 bits): " + Long.parseLong(hex, 16));
        part1 = String.format("%02x", b[index]);
        part2 = String.format("%02x", b[index + 1]);
        String part3 = String.format("%02x", b[index + 2]);
        String part4 = String.format("%02x", b[index + 3]);
        hex = part1 + part2 + part3 + part4;
        index += 4;
        sb.append("\nTCP: Sequence Number(32 bits): " + Long.parseLong(hex, 16));
        part1 = String.format("%02x", b[index]);
        part2 = String.format("%02x", b[index + 1]);
        part3 = String.format("%02x", b[index + 2]);
        part4 = String.format("%02x", b[index + 3]);
        hex = part1 + part2 + part3 + part4;
        index += 4;
        sb.append("\nTCP: Ack Number(32 bits): " + Long.parseLong(hex, 16));
        int header_length = ((b[index] >>> 4) & 0x0f) * 4;
        TCP_header_length = header_length;
        setSize_of_data(IP_header_length - TCP_header_length);
        sb.append("\nTCP: Data Offset/Header length(4 bits): " + TCP_header_length + " bytes");
        int NS = b[index] & 0x01;
        String flag = String.format("%01x", NS);
        index++;
        flag += String.format("%02x", b[index]);
        sb.append("\nTCP: Flag(9 bits): 0x" + flag);
        if (NS == 0)
            sb.append("\nTCP:    " + NS + " .... .... = No NS");
        else
            sb.append("\nTCP:      .... ..." + NS + " = NS");
        String flags = String.format("%01x", (b[index] & 0x80) >>> 7);
        flags += "... ....";
        if (flags.equals("0... ...."))
            sb.append("\nTCP:      " + flags + " = No CWR");
        else
            sb.append("\nTCP:      " + flags + " = CWR");
        flags = "";
        flags = "." + String.format("%01x", (b[index] & 0x40) >>> 6);
        flags += ".. ....";
        if (flags.equals(".0.. ...."))
            sb.append("\nTCP:      " + flags + " = No ECE");
        else
            sb.append("\nTCP:      " + flags + " = ECE");
        flags = "";
        flags = ".." + String.format("%01x", (b[index] & 0x20) >>> 5);
        flags += ". ....";
        if (flags.equals("..0. ...."))
            sb.append("\nTCP:      " + flags + " = No urgent pointer");
        else
            sb.append("\nTCP:      " + flags + " = urgent pointer");
        flags = "";
        flags = "..." + String.format("%01x", (b[index] & 0x10) >>> 4);
        flags += " ....";
        if (flags.equals("...0 ...."))
            sb.append("\nTCP:      " + flags + " = No Ack");
        else
            sb.append("\nTCP:      " + flags + " = Ack");
        flags = "";
        flags = ".... " + String.format("%01x", (b[index] & 0x8) >>> 3);
        flags += "...";
        if (flags.equals(".... 0..."))
            sb.append("\nTCP:      " + flags + " = No Push");
        else
            sb.append("\nTCP:      " + flags + " = Push");
        flags = "";
        flags = ".... ." + String.format("%01x", (b[index] & 0x4) >>> 2);
        flags += "..";
        if (flags.equals(".... .0.."))
            sb.append("\nTCP:      " + flags + " = No Reset");
        else
            sb.append("\nTCP:      " + flags + " = Reset");
        flags = "";
        flags = ".... .." + String.format("%01x", (b[index] & 0x2) >>> 1);
        flags += ".";
        if (flags.equals(".... ..0."))
            sb.append("\nTCP:      " + flags + " = No Syn");
        else
            sb.append("\nTCP:      " + flags + " = Syn");
        flags = "";
        flags = ".... ..." + String.format("%01x", (b[index] & 0x1));
        flags += "";
        if (flags.equals(".... ...0"))
            sb.append("\nTCP:      " + flags + " = No Fin");
        else
            sb.append("\nTCP:      " + flags + " = Fin");
        flags = "";
        index += 1;
        part1 = String.format("%02x", b[index]);
        part2 = String.format("%02x", b[index + 1]);
        hex = part1 + part2;
        index += 2;
        sb.append("\nTCP: Window Size(16 bits): " + Long.parseLong(hex, 16));
        part1 = String.format("%02x", b[index]);
        part2 = String.format("%02x", b[index + 1]);
        hex = part1 + part2;
        index += 2;
        sb.append("\nTCP: Checksum(16 bits): 0x" + hex);
        part1 = String.format("%02x", b[index]);
        part2 = String.format("%02x", b[index + 1]);
        hex = part1 + part2;
        index += 2;
        sb.append("\nTCP: Urgent Pointer(16 bits): " + Long.parseLong(hex, 16));
        // index += 1;
        if (index == begin_index + header_length)
            sb.append("\nTCP: no options");
        else {
            sb.append("\nTCP: Options found :" + (header_length - 20) + " bytes");
            index = index + (header_length - 20);
        }
        if ((b.length - header_length - 34) == 0)
            sb.append("\nTCP: No Data");
        else {
            sb.append("\nTCP: Data: " + (b.length - header_length - 34) + " bytes");
            print_data(sb, b, index - 1);
        }
        sb.append("\n\n ||||||||||||||||||||||||||||");
        setCurrent_start_index(index);

        return sb.toString();
    }

    /**
     * This function is used to print the data in packet
     * 
     * @param b
     *            The byte array
     * @param index
     *            The index to start from
     */
    private void print_data(final StringBuilder sb, byte[] b, int index) {
        sb.append("\t");
        for (int i = index; i < b.length; i++) {
            if ((i - index) % 32 != 0) {
                sb.append(String.format("%02x", b[i]));
            } else {
                sb.append("\n");
                sb.append("\t");
            }
        }
        sb.append("\n");
        sb.append("\t");
        for (int i = index; i < b.length; i++) {
            if ((i - index) % 32 != 0) {
                if ((b[i] > 48 && b[i] < 57) || (b[i] >= 65 && b[i] < 126)) {
                    sb.append((char) b[i]);
                } else {
                    sb.append(".");
                }
            } else if (i != index)
                sb.append("\n\t");
        }
    }

    /**
     * This function parses the UDP Header and analyzes its sub parts
     * 
     * @param b
     *            The byte array
     * @param begin_index
     *            The beginning index for this header
     */
    private String UDP_packet_parser(byte[] b, int begin_index) {
        final StringBuilder sb = new StringBuilder();
        int index = begin_index;
        sb.append("\nUDP:   ----- UDP Header -----");
        String part1 = String.format("%02x", b[index]);
        String part2 = String.format("%02x", b[index + 1]);
        String hex = part1 + part2;
        sb.append("\nUDP: Source Port(16 bits): " + Long.parseLong(hex, 16));
        index += 2;
        part1 = String.format("%02x", b[index]);
        part2 = String.format("%02x", b[index + 1]);
        hex = part1 + part2;
        sb.append("\nUDP: Destination Port(16 bits): " + Long.parseLong(hex, 16));
        index += 2;
        part1 = String.format("%02x", b[index]);
        part2 = String.format("%02x", b[index + 1]);
        hex = part1 + part2;
        sb.append("\nUDP: Length(16 bits): " + Long.parseLong(hex, 16));
        index += 2;
        part1 = String.format("%02x", b[index]);
        part2 = String.format("%02x", b[index + 1]);
        hex = part1 + part2;
        sb.append("\nUDP: Checksum(16 bits): 0x" + hex);
        index += 2;
        // while (index != b.length) {
        // System.out.print(String.format("%02x", b[index]));
        // index++;
        // }
        if (index != b.length)
            print_data(sb, b, index - 1);
        sb.append("\n\n ||||||||||||||||||||||||||||");
        setCurrent_start_index(index);

        return sb.toString();
    }

    /**
     * This function parses the ICMP Header and analyzes its sub parts
     * 
     * @param b
     *            The byte array
     * @param begin_index
     *            The beginning index for this header
     */
    private String ICMP_packet_parser(byte[] b, int begin_index) {
        final StringBuilder sb = new StringBuilder();
        int index = begin_index;
        sb.append("\nICMP:   ----- ICMP Header -----");
        sb.append("\nICMP: Type(8 bits): " + String.format("%01x", b[index]));
        index++;
        sb.append("\nICMP: Code(8 bits): " + String.format("%01x", b[index]));
        index++;
        String part1 = String.format("%02x", b[index]);
        String part2 = String.format("%02x", b[index + 1]);
        String hex = part1 + part2;
        sb.append("\nICMP: Checksum(16 bits): 0x" + hex);
        sb.append("\n\n|||||||||||||||||||||||||||||");
        setCurrent_start_index(index);

        return sb.toString();
    }

    /**
     * This is the main function of the class
     * 
     * @param args
     */
    public static void main(String[] args) {
        String f = "resource/new_icmp_packet2.bin";
        String of = "resource/new_icmp_packet2.out";
        if (args.length == 0) {
            System.out.println("\nNo file name entered using default file " + f);
        } else {
            f = args[0];
        }

        File file = new File(f);

        if (!file.exists()) {
            System.out.println("\nThe file " + f + " does not exist!!");
        }

        Pktanalyzer PA = new Pktanalyzer();
        try
        {
            byte[] filebytes = PA.readFile(file);
            //PA.print_hex(filebytes);
            String result = PA.Ether_packet_parser(filebytes);
            System.out.println(result);

            System.out.println("SIZE OF DATA : " + PA.getSize_of_data());

            PA.saveFileTo(of, result);
        }
        catch(IOException ie)
        {
            System.out.println("\nParsing error of the file " + f + "!!");
            ie.printStackTrace();
        }

    }

    private void saveFileTo(String of, String result) {
        PrintWriter out = null;

        try {
            out = new PrintWriter(new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(of))));
            out.print(result);
            out.flush();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }
        finally
        {
            if(out !=  null) out.close();
        }
    }

    public long getSize_of_data() {
        return size_of_data;
    }

    private void setSize_of_data(long size_of_data) {
        this.size_of_data = size_of_data;
    }

    public int getCurrent_start_index() {
        return current_start_index;
    }

    private void setCurrent_start_index(int current_start_index) {
        this.current_start_index = current_start_index;
    }

}