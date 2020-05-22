String example = "  sl  local_address rem_address   st tx_queue rx_queue tr tm->when retrnsmt   uid  timeout inode\n" +
    "   0: 00000000:04D2 00000000:0000 0A 00000000:00000000 00:00000000 00000000     0        0 15662 1 ffff8800baf1c780 100 0 0 10 0\n" +
    "   1: 00000000:04D2 00000000:0000 0A 00000000:00000000 00:00000000 00000000     0        0 15662 1 ffff8800baf1c780 100 0 0 10 0";

Scanner scanner = new Scanner(example);
scanner.useRadix(16).useDelimiter("[\\s:]+");
Set<Integer> result = new HashSet<>();
scanner.next();

while (scanner.hasNextLine()) {
    String skipped = scanner.nextLine();
    System.out.println("Skipped: " + skipped); // skip header on first iteration and also skips remainder of previous line after we read the int
    if (scanner.hasNextInt()) {
        int slot = scanner.nextInt();
        System.out.println(slot);
    } else {
        System.out.println("No int avaialble");
    }
}

System.out.println("Done");