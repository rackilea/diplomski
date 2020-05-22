public static void main(String args[]) {
    Scanner theScanner = new Scanner(System.in);
    System.out.print('List which die to throw again: ');
    while (theScanner.hasNextLine()) {

        String theLine = theScanner.nextLine();
        String[] split = theLine.split(" ");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
            // Do something with each entry
        }

        System.out.print("List which die to throw again: ");
    }

}