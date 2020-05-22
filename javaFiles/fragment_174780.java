public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int[] vals = new int[MAX_NUM_OF_VALUES];
    int numOfVals = 0;

    System.out.println( "Enter integers <= 25, one per line, hit control-Z when done: " );
    while (in.hasNextLine()) {
        vals[numOfVals] = Integer.parseInt(in.nextLine());
        ++numOfVals;
    }
    if(numOfVals == 0)
        System.exit(0);

    int[] counts = new int[25];

    //changed counts.length to numOfVals
    for (int i = 0; i < numOfVals; i++) {
        counts[vals[i]-1]++; 
    }

    //display values entered
    System.out.print("Entered values: ");
    for (int i = 0; i < numOfVals; ++i) {
        System.out.print(vals[i]);
    }
    System.out.println(); //new line

    //display counted integers
    System.out.print("Counts of the values: ");
    for (int i = 0; i < counts.length; ++i) {
        System.out.print(counts[i]);
    }
}