private Boolean runsOnBattery() {
    try {
        Process proc = Runtime.getRuntime().exec("cmd.exe /c battstat.bat");

        BufferedReader stdInput = new BufferedReader(
            new InputStreamReader(proc.getInputStream()));

        String s;
        while ((s = stdInput.readLine()) != null) {
            if (s.contains("mains power")) {
                return false;
            } else if (s.contains("Discharging")) {
                return true;
            }
        }
    } catch (IOException ex) {
        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }

    return false;
}