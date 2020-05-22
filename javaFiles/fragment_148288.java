//We can use a Scanner for convenience, it has a readInt() method
Scanner input = new Scanner(/*your input*/);

int numCases = input.readInt();

for(int i = 0; i < numCases; i++) {
    int first = input.readInt(); //readInt() will also skip newlines, just a tip.
    int second = input.readInt();
    /* Compare two inputs, do stuff*/
}