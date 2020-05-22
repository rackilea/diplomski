public class ArrayDirectory {
public static void main(String args[]) throws FileNotFoundException {
    String file = ("lab4b2.txt");
    Scanner scan = new Scanner(new FileReader(file));
    // initialises the scanner to read the file file

    String[][] entries = new String[100][3];
    // creates a 2d array with 100 rows and 3 columns.

    int i = 0;
    while(scan.hasNextLine()){
        entries[i] = scan.nextLine().split("\t");
        i++;
    }
    //loops through the file and splits on a tab

    for (int row = 0; row < entries.length; row++) {
        for (int col = 0; col < entries[0].length; col++) {
            if(entries[row][col] != null){
                System.out.print(entries[row][col] + " " );
            }
        }
        if(entries[row][0] != null){
            System.out.print("\n");
        }
    }
    //prints the contents of the array that are not "null"
}
}