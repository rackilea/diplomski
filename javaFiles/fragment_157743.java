public static void main(String[] args) throws FileNotFoundException {
    Scanner iScanner = new Scanner(System.in);
    System.out.println("Enter your SSN in the formate YYDDMM:\n");
    String ssn = iScanner.nextLine();
    System.out.println(ssn.substring(ssn.length() - 2));
}