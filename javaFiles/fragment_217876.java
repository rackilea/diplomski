Process p = Runtime.getRuntime().exec(
    new String[]{"java", "-cp", "/my/path/to/my/classes", "Echo"}
);
// The Observable object allowing to get the input lines from my external process
ObservableStream input = new ObservableStream();
// A mock observer that simply prints the lines provided by the external process
// but in your case you will update your text area instead
input.addObserver(
    (o, arg) -> {
        ObservableStream stream = (ObservableStream) o;
        String line;
        while ((line = stream.nextLine()) != null) {
            System.out.printf("Line Received from the external process: %s%n", line);
        }
    }
);
// The thread that reads the standard output stream of the external process 
// and put the lines into my variable input
new Thread(
    () -> {
        try (BufferedReader reader = new BufferedReader(
            new InputStreamReader(p.getInputStream()))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                input.addLine(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
).start();
// The Observable object allowing to send the input lines to my external process
ObservableStream output = new ObservableStream();
// Observer that simply sends to my external process line by line what we put in
// the variable output
PrintWriter writer = new PrintWriter(p.getOutputStream(), true);
output.addObserver(
    (o, arg) -> {
        ObservableStream stream = (ObservableStream) o;
        String line;
        while ((line = stream.nextLine()) != null) {
            writer.println(line);
        }
    }
);

// A simple scanner used to send new messages to my external process
Scanner scanner = new Scanner(System.in);
while (true) {
    output.addLine(scanner.nextLine());
}