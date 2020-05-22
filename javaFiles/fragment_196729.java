public List<String> validation() {
    List<String> accnumbers = new ArrayList<String>();
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter account numbers (blank to finish):");
    while (true) {
        String accno = sc.nextLine(); 
        if (accno.equals("")) { // blank ends input
            return accnumbers;
        }
        accnumbers.add(accno); // will take any number of account numbers
    }
}