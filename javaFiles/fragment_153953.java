public final class InteractWithExternalApp {

private static BufferedReader inputReader, errorReader;
private static OutputStream outputStream;
private static PrintStream printOutputStream;

private InteractWithExternalApp (){} // suppressing the class constructor

public static void Evaluate(String paramToApp) {
    System.out.println("Running evaluation tests...");

    try
    {
        ProcessBuilder pb = new ProcessBuilder("Path/to/my/C/application", "paramToApp");
        pb.redirectOutput(Redirect.INHERIT);
        pb.redirectError(Redirect.INHERIT);
        Process process = pb.start();

        String line;

        errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        while((line = errorReader.readLine()) != null){
            System.out.println(line);
        }

        inputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        while((line = errorReader.readLine()) != null){
            System.out.println(line);
        }

        outputStream = process.getOutputStream();
        printOutputStream = new PrintStream(outputStream);
        printOutputStream.println("A parameter"); printOutputStream.flush();
        printOutputStream.println("Another parameter"); printOutputStream.flush();
        printOutputStream.println("And however many more I would need to finally get where I wanted"); printOutputStream.flush();

        inputReader.close();
        errorReader.close();
        printOutputStream.close();

    } catch(IOException ioe){
        System.out.println("Error during evaluation routine: " + ioe.getMessage());
    } finally {
        System.out.println("Evaluation complete!");
    }

    return;
}