public boolean isAdmin() {
    if (Platform.isMac()) {
        try {
            Process p = Runtime.getRuntime().exec("id -Gn");
            InputStream is = p.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, StandardCharsets.US_ASCII);
            BufferedReader br = new BufferedReader(isr);
            p.waitFor();
            int exitValue = p.exitValue();
            String exitLine = br.readLine();
            if (exitValue != 0 || exitLine == null || exitLine.isEmpty()) {
                HandleError..
                return false;
            }
            if (exitLine.matches(".*\\badmin\\b.*")) {
                return true;
            }
            return false;
        } catch (IOException | InterruptedException e) {
            HandleError..
        }
    }
}