/**
    *
    * @author nika
    */
    public class JavaFXConsole extends Application {

ProcessBuilder pb;
Process process;
TextArea ta;
String input = "";
int counter = 0;
BufferedReader stdInput, stdError;
OutputStream out;

//static BufferedReader stdInput, stdError;
//static Thread outputThread;
@Override
public void start(Stage primaryStage) throws InterruptedException {
    ta = new TextArea("/bin/bash\n");
    ta.setOnKeyTyped(new EventHandler<KeyEvent>() {

        @Override
        public void handle(KeyEvent event) {
            {

                input = input.concat(event.getCharacter());
                System.out.println(input);
            }

        }
    });

    final KeyCombination keyComb1 = new KeyCodeCombination(KeyCode.C,
            KeyCombination.CONTROL_DOWN);
    ta.setOnKeyPressed(new EventHandler<KeyEvent>() {

        @Override
        public void handle(KeyEvent event) {
            if (event.getCode() == KeyCode.ENTER) {
                try {
                    //getOutPut(input+"\n");
                    String command = input.replaceAll("\r", "") + "\n";
                    command = input.replaceAll("\b", "");
                    out.write(command.getBytes());
                    out.flush();
                    //getOutPut(command);
                    input = "";
                    System.out.println("Command Sent");
                } catch (IOException ex) {
                    Logger.getLogger(JavaFXConsole.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (keyComb1.match(event)) {

                System.out.println("Control+C pressed");
            }else if (event.getCode()== KeyCode.BACK_SPACE){
             //    input=input.substring(0, input.length()-1);
              //  System.out.println(input);
            }

        }
    });

    HBox root = new HBox();
    root.getChildren().add(ta);

    pb = new ProcessBuilder("/bin/bash");
    new Thread(new Runnable() {

        @Override
        public void run() {
            try {
                process = pb.start();
                stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));

                stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

                //OutputStream out;
                out = process.getOutputStream();

                StreamGobbler errorGobbler = new StreamGobbler(process.getErrorStream(), "ERROR");

    // any output?
                StreamGobbler outputGobbler = new StreamGobbler(process.getInputStream(), "OUTPUT");

    // start gobblers
                outputGobbler.start();
                errorGobbler.start();

                process.waitFor();

            } catch (IOException ex) {
                Logger.getLogger(JavaFXConsole.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(JavaFXConsole.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }).start();

    Scene scene = new Scene(root, 300, 250);

    primaryStage.setTitle("Hello World!");
    primaryStage.setScene(scene);
    primaryStage.show();

}


private class StreamGobbler extends Thread {

    InputStream is;
    String type;

    private StreamGobbler(InputStream is, String type) {
        this.is = is;
        this.type = type;
    }

    @Override
    public void run() {
        try {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(type + "> " + line);
                String str =line;
                 Platform.runLater(new Runnable() {

                        @Override
                        public void run() {
                            ta.appendText(">" + str + "\n");

                        }
                    });
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}

/**
 * @param args the command line arguments
 */
public static void main(String[] args) {
    launch(args);
}

}