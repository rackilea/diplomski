public static void main(String[] args) throws FileNotFoundException {
    final int TOTALNAMES = 15;
    int cntr = 0;
    String [] names = new String[TOTALNAMES];
    String [] firstname = new String[TOTALNAMES];
    String [] lastname = new String[TOTALNAMES];

    File file = new File("Names12.txt");
    Scanner  read = new Scanner(file);
    printHeading();

    while(read.hasNext() && cntr < TOTALNAMES){
        cntr++;
        names[cntr - 1] = read.nextLine();
    }

    read.close();

    for(int i = 0; i < cntr; i++){
        //firstname[i] = names[i].substring(0, names[i].indexOf(" "));
        lastname[i] = names[i].substring(names[i].indexOf(" ") + 1);
        System.out.println(lastname[i]);
    }
}