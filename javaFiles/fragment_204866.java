Scanner in = new Scanner(System.in);
if (!in.hasNextInt()) exitAndPrintError();
int rows = in.nextInt();
if (!in.hasNextInt()) exitAndPrintError();
int cols = in.nextInt();
for (int r = 0; r < rows; r++) {
    for (int c = 0; c < cols; c++) {
        if (!in.hasNext()) exitAndPrintError();
        process(in.next());
    }
}