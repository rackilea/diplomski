while (scan.hasNext()) {
    String x = scan.nextLine();
    String s;
    if (!x.isEmpty()) { // <-- here
        s = x.substring(0,1);
    } else {
        s = "";
    }
    // use s as needed...
}