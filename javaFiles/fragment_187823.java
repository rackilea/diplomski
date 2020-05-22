private ExecutorService executorService = Executors.newSingleThreadExecutor();

public void runTest(ArrayList<String> arr) throws InterruptedException{
    Thread t = new Thread(() -> {
        try {
            ProcessBuilder builder = new ProcessBuilder(arr);
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while((line = r.readLine()) != null){
                //sb.append(line).append("\n");//Remove this if thats all you were using it for
                Platform.runLater(()->txtOutputArea.appendText(line + "\n"));
            }
            System.out.println(line);//Move this inside the loop if you want it to print th output to the console
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    });
    executorService.submit(t);
}