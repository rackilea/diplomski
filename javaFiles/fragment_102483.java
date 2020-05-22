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
        //1. Read package bytes from a specific file.
        byte[] filebytes = PA.readFile(file);
        //2. Print bytes in a hex format if needed..
        //Pktanalyzer.print_hex(filebytes);
        //3. Analyze it and make a result string
        String result = PA.Ether_packet_parser(filebytes);
        System.out.println(result);
        System.out.println("SIZE OF DATA : " + PA.getSize_of_data());
        //4. Finally, save the result to a default file.
        PA.saveFileTo(of, result);
    }
    catch(IOException ie)
    {
        System.out.println("\nParsing error of the file " + f + "!!");
        ie.printStackTrace();
    }

}