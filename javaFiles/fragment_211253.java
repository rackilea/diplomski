public static void main(String args[]) throws IOException {
    BufferedReader inpt = new BufferedReader(new InputStreamReader(
            System.in));

    int[] arrayCrit = new int[5];
    String[] crits = new String[5];

    for (int i = 0; i < crits.length; i++) {
        System.out.print("Enter Criteria: ");
        crits[i] = inpt.readLine();
        System.out.print("Enter Percentage: ");
        arrayCrit[i] = Integer.parseInt(inpt.readLine());
    }
    // Printing the values
    for (int i = 0; i < crits.length; i++) {
        System.out.println("Criteria :" + crits[i] + " Percentage: "
                + arrayCrit[i]);
    }
}