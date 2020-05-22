int nmar, max;

while (input.hasNextLine()) {
    nmar = 0;
    max = 0;
    input.useDelimiter("%");
    String nume = input.next();
    Scanner scan = new Scanner(nume);

    while (scan.hasNextLine()) {
        String linecount = scan.nextLine();
        nmar = linecount.length();

        if (nmar > max) {
            max = nmar;
        } else if (nmar == 0) {
            break;
        }

    }
    System.out.println(max);
}