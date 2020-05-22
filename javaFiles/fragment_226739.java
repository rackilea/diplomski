private static String executeCommand(String command) {
    Process process = null;
    BufferedReader reader = null;
    String result = "";
    try {
        String line;
        process = Runtime.getRuntime().exec(command);
        reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        while ((line = reader.readLine()) != null)
            result += line + "\n";
    } catch (final Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (reader != null)
                reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (process != null)
                process.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    return result;
}