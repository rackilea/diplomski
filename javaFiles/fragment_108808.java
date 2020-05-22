Scanner myScanner = new Scanner(System.in);

while(myScanner.hasNext() && !myScanner.equals("$")) {
    System.out.println(this.englishToMorse(myScanner.nextLine()));
}

myScanner.close();