private String executeCommand(String command) {     
    StringBuilder output = new StringBuilder();
            BufferedReader reader = null;
    Process p;
    try {
        p = Runtime.getRuntime().exec(command);
        reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

        String line = "";
        while ((line = reader.readLine())!= null) {
            output.append(line + "\n");
        }
        p.waitFor();

    } catch (Exception e) {
        e.printStackTrace();
    }
    return output.toString();
}