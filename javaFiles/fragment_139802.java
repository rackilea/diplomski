// Client.java
import java.io.IOException;

public class Client {
    public static void main(String args[]) {
        try {
            InstructionList il = new InstructionList();
            il.readFile("C:\\testing\\ints.txt", 5);

            int[] integers = il.getInstructionsAsIntegers();

            if (integers != null) {
                for (int i : integers) {
                    System.out.println(i);
                }
            }
        } catch (IOException e) {
            // handle
        }
    }
}


// InstructionList.java
import java.io.*;

public class InstructionList {
    private String[] instructions;

    public void readFile(String path, int lineLimit) throws IOException {
        FileInputStream in = new FileInputStream(path);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        instructions = new String[lineLimit];

        for (int i = 0; i < lineLimit; i++) {
            instructions[i] = br.readLine();
        }

        in.close();
    }

    public String[] getInstructionsAsStrings() {
        return instructions; // will return null if uninitialized
    }

    public int[] getInstructionsAsIntegers() {
        if (this.instructions == null) {
            return null;
        }

        int[] instructions = new int[this.instructions.length];

        try {
            for (int i = 0; i < instructions.length; i++) {
                instructions[i] = new Integer(this.instructions[i]);
            }
        } catch (NumberFormatException e) {
            return null; // data integrity fail, return null
        }

        return instructions;
    }
}