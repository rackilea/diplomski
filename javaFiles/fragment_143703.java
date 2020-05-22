public static void main(String[] args){
    if(args.length == 0 && System.getProperty("os.name").toLowerCase().contains("mac")){
        try {
            String path = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getAbsolutePath();
            String command = "tell application \"Terminal\"\n" + 
                    "do script \"java -jar \'" + path + "\' isInConsole\"\n" + 
                    "close the front window\n" + // because "do script..." opens another window
                    "activate\n" + 
                    "end tell";
            String[] arguments = new String[]{"osascript", "-e", command};

            Runtime.getRuntime().exec(arguments);
            System.exit(0);
        } catch (IOException | URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    // program continues...
}