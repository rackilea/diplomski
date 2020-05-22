String example = "  sl  local_address rem_address   st tx_queue rx_queue tr tm->when retrnsmt   uid  timeout inode\n" +
    "   0: 00000000:04D2 00000000:0000 0A 00000000:00000000 00:00000000 00000000     0        0 15662 1 ffff8800baf1c780 100 0 0 10 0\n" +
    "   1: 00000000:04D2 00000000:0000 0A 00000000:00000000 00:00000000 00000000     0        0 15662 1 ffff8800baf1c780 100 0 0 10 0";

Scanner scanner = new Scanner(example);
scanner.useRadix(16).useDelimiter("[\\s:]+");
Set<Integer> result = new HashSet<>();
scanner.next();

if (scanner.hasNextLine()) {
    // Skip the headers
    scanner.nextLine();
}
// Process records
while (scanner.hasNextLine()) {
    // The first int
    if (scanner.hasNextInt()) {
        int slot = scanner.nextInt();
        System.out.println(slot);

        // Read anything else you want from that line, until
        // you have only the newline left (or any trailing characters
        // you don't want to process and then the newline)
    }

    // Clear the newline
    scanner.nextLine();
}

System.out.println("Done");