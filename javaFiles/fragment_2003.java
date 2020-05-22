Scanner in = new Scanner(System.in);
int q = in.nextInt();

// q quadrants
for (int iQuadrat = 0; iQuadrat < q; iQuadrat++) {

    // count will keep track of the last number you print
    int count = 0;
    // q rows
    for (int iRow = 0; iRow < q; iRow++) {
        // q cols
        for (int iCol = 0; iCol < q; iCol++) {
            System.out.print(count);
            // increment the count and take its modulo 10 so it stays between 0 and 9
            count = (count+1)%10;
        }
        // line return at the end of the row
        System.out.println();
    }
    // line return between quadrants
    System.out.println();
}