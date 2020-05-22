String r, g, b;
Scanner scanner = new Scanner(myFile);
while(scanner.hasNext()) {
    String next = scanner.next();
    if(next.equals("Color:")) {
        r = scanner.next();
        g = scanner.next();
        b = scanner.next();
        // do stuff with the values
    }
 }