public static void main(String[] args) {

    Properties prop = new Properties();
    OutputStream output = null;

    try {
        //load the file into properties object
        FileInputStream input = new FileInputStream("config.properties");    
        prop.load(input);
        input.close();

        // set the properties value
        output = new FileOutputStream("config.properties");
        prop.setProperty("app.num_hosts", "4");
        prop.setProperty("app.resourceid", "broker0");
        prop.store(output, null);


    } catch (IOException io) {
        io.printStackTrace();
    } finally {
        if (output != null) {
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}