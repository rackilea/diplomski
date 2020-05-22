private static void printRow(String c0, String c1, String c2, String c3 ) {
    System.out.printf("%-20s %-20s %-20s %-20s%n", c0, c1, c2, c3);
}
public static void main(String[] args) {

        printRow(" ", "", "List of Appartments", " ");
        printRow( "==============", "==============", "==============", "==============");

        printRow("Region", "Country", "Adresse", "PriceMunicipilaty");
        printRow("==============", "==============", "==============", "==============");
        printRow("Adress1", "Adress1" , "Adress1", "Adress2");
}