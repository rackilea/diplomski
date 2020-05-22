public class Example {

    public static void main(String[] args) {

        boolean hasE = false;
        boolean hasN = false;
        String message = args[args.length - 1];

        for (int i = args.length - 2; i >= 0; i--) {
            switch (args[i]) {
                case "-n": hasN = true; break;
                case "-e": hasE = true; break;
            }
        }

        if (hasE)
            message = message.replace("\\n", "\n").replace("\\t", "\t");
        if (hasN)
            System.out.print(message);
        else
            System.out.println(message);
        System.out.println("Test");
    }
}