import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ContactListDriver {

    public static void main(String[] args) throws IOException, FileNotFoundException {
        File inputFile = new File("C:/Users/Gab Real/workspace/CSc121/MyContacts.txt");
        //System.out.println(String.format("File.canWrite() says %s", inputFile.canWrite()));

        //System.out.println(inputFile.getAbsolutePath());  
        BufferedReader reader = null;
        BufferedReader reader2 = null;
        BufferedReader reader3 = null;
        FileWriter out = null;
        String ls = System.getProperty("line.separator");
        //File tempFile = new File("temp1.txt");
        try {
            Scanner scan = new Scanner(System.in);
            String word = "";

            System.out.println("oooooooooooooooooooooo[Instructions]ooooooooooooooooooooooooooooooooooo");
            System.out.println("o use command 'show' to show all contacts                             o");
            System.out.println("o use command 'add' to add a contact (e.g. add Gabrielle 25485878555) o");
            System.out.println("o use command 'remove' + the name of the contact to remove a Contact  o");
            System.out.println("o use command 'exit' to exit the program                              o");
            System.out.println("ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");

            while (!word.contentEquals("exit")) {
                System.out.println("\nEnter a command: ");
                word = scan.nextLine();
                String entries[] = word.split(" ");

                if (entries[0].equalsIgnoreCase("add")) {
                    out = new FileWriter(inputFile, true);
                    out.write(ls + entries[1] + " " + entries[2]);
                    out.flush();
                    //out.println(out.toString());
                    //out.write("\r\n");
                } else if (entries[0].equalsIgnoreCase("remove")) {
                    String allLines = "";
                    String currentLine;
                    reader = new BufferedReader(new FileReader(inputFile));

                    while ((currentLine = reader.readLine()) != null) {
                        allLines = allLines + "|" + currentLine;
                    }
                    String[] allLinesArr = allLines.split("\\|");

                    out = new FileWriter(inputFile, false);
                    for (int i = 0; i < allLinesArr.length; i++) {
                        currentLine = allLinesArr[i];
                        if (currentLine.contains(entries[1])) {
                            System.out.println("Deleting " + entries[1]);
                            continue;
                        }
                        if (i == 0) {
                            out.write(currentLine);
                        } else {
                            out.write(ls + currentLine);
                        }
                    }
                    out.flush();
                } else if (entries[0].equalsIgnoreCase("show")) {
                    reader = new BufferedReader(new FileReader(inputFile));
                    String currentLine;
                    while ((currentLine = reader.readLine()) != null) {
                        // trim newline when comparing with lineToRemove
                        System.out.println(currentLine);
                    }
                }
            }

        } finally {
            if (out != null) {
                out.close();
            }
            if (reader != null) {
                reader.close();
            }
        }

    }
}