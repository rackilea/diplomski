public class Bags {

public static void main(String[] args) throws IOException {
    FileInputStream fileinput = new FileInputStream("input.txt");
    FileOutputStream fileoutput = new FileOutputStream("output.txt");
    Scanner infile = new Scanner(fileinput);
    PrintWriter pw = new PrintWriter(fileoutput);
    double total = 0, line = 0;
    int bags = 0, ID = 0, count = 0;
    pw.println("ID\t\tNumber of Bags\t\t\tTotal Cost");
    while(infile.hasNext()){

        ID = infile.nextInt();
        int i = infile.nextInt();
        if (i <= 0) {
            pw.println(ID + "\n\t\tError: Wrong Number of Bags\t\t\t");

        } else if (i <= 4) {
            total = (80.50) * i;
            pw.printf("%d\t\t%d\t\t\t\t%.2f", ID, i, total);

        } else {
            total = ((80.50) * 4) + ((75.50) * (i - 4));
            pw.printf("%d\t\t%d\t\t\t\t%.2f", ID, i, total);

        }
    }
    infile.close();
    pw.close();
}
}