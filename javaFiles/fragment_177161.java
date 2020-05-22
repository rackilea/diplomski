import java.io.*;

public class PostFixEval {
    public static void main(String[] args) throws StackException, IOException {
        File fin = new File(args[0]);
        boolean fileExist = fin.exists();

        File fout = new File(args[1]);
        try (PrintWriter pw = new PrintWriter(new FileWriter(fout))) {
            if (fileExist == true) {
                pw.println("\n" + "\t\t\t\t" + "--- EVALUATION BEGINS ---");
                parseFromFile(args[0], pw);
            }
            else {
                translate(args[0], pw);
            }
            pw.println("\t\t\t\t" + "--- EVALUATION COMLETE ---" + "\n");
        }
    }

    public static void parseFromFile(String input, PrintWriter pw) throws IOException {
        String line = null;
        int lineCounter = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(input));

            try {
                while ((line = br.readLine()) != null) {
                    lineCounter++;
                    pw.println("EXAMPLE " + lineCounter + ": ");
                    pw.println("Postfix Expression: " + line);

                    try {
                        translate(line, pw);
                    }
                    catch (StackException e) {
                        pw.println("ERROR: Invalid expression encountered: exiting");
                        pw.println(e);
                    }
                    pw.println("\n");
                }
                br.close();
            }
            catch (java.io.IOException e) {
                pw.println("EOF encountered");
            }

        }
        catch (java.io.FileNotFoundException e) {
            pw.println("Cannot find file: " + input);
        }
    }

    private static boolean isOperator(String operator) {
        switch (operator) {
            case "+":
            case "-":
            case "*":
            case "/":
            case "$":
                return true;
            default:
                return false;
        }
    }

    private static String instruction(String oper) {
        switch (oper) {
            case "+":
                return "AD";
            case "-":
                return "SB";
            case "*":
                return "ML";
            case "/":
                return "DV";
            case "$":
                return "EX";
            default:
                return "N/A";
        }
    }

    public static void translate(String expression, PrintWriter pw) throws StackException, IOException {
        Stack variables = new Stack();
        int tempNum = 1;
        String arg1;
        String arg2;
        String command;

        pw.println("Instructions in the Register:");
        if (expression == null) {
            throw new IllegalArgumentException("null expression");
        }
        expression = expression.trim();
        if (expression.length() == 0) {
            throw new StackException("EMPTY STACK");
        }
        int limit = expression.length() - 1;
        for (int i = 0; i < limit; i++) {
            String argument = expression.substring(i, i + 1);
            // if operator, pop arguements and evaluate
            if (isOperator(argument)) {
                if (variables.isEmpty()) {
                    throw new StackException("EMPTY STACK");
                }
                command = instruction(expression.substring(i, i + 1));
                try {
                    arg1 = variables.pop();
                }
                catch (StackException e) {
                    throw new StackException("EMPTY STACK ON ARG1");
                }

                try {
                    arg2 = variables.pop();
                }
                catch (StackException e) {
                    throw new StackException("EMPTY STACK ON ARG2");
                }

                variables.push("TEMP" + tempNum);
                pw.println("LD " + arg2);
                pw.println(command + " " + arg1);
                pw.println("ST " + "TEMP" + tempNum);
                tempNum++;
            }
            else if (Character.isLetter(expression.charAt(i))) {
                variables.push(argument);
                // if variab.l+ng(i, i+1));
            }
            else if (Character.isWhitespace(expression.charAt(i))) {
                // Ignore whitespace
                continue;
            }
            else {
                throw new StackException(
                        "Unrecognized characterr: " + expression.charAt(i) + " at position: " + i);
            }
        }

        if (variables.isEmpty() == false) {
            while (variables.isEmpty() == false) {
                if (variables.pop().startsWith("TEMP") == false) {
                    throw new StackException("Leftover variables after evaluation.");
                }
            }
        }
    }
}