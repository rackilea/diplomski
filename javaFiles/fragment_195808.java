public void checkLogin() throws FileNotFoundException, IOException {
    // Try with Resources...This will auto-close the BufferReader.
    try (BufferedReader br = new BufferedReader(new FileReader("D:\\Login.txt"))) {
        // Install code here to validate that txfUsername and txfPassword 
        // text boxes actually contain something. Exit method if not.
        // ................................

        String userName = txfUsername.getText();
        // Encrypt supplied password and compare to what is in file
        String password = Base64.getEncoder().withoutPadding().encodeToString(String.valueOf(txfPassword.getPassword()).getBytes());

        if (userName.equals("") || password.equals("")) {
            return;
        }

        String line;
        int lineCounter = 0;
        boolean loginSuccess = false;
        while ((line = br.readLine().trim()) != null) {
            lineCounter++;
            // Is this the right data file?
            if (lineCounter == 1 && !line.equals(";MyAppName Login Data")) {
                JOptionPane.showMessageDialog(this, "Wrong Text File Supplied!",
                        "Invalid Data File", JOptionPane.WARNING_MESSAGE);
                return;
            }
            // Skip blank and comment lines...
            if (line.equals("") || line.startsWith(";")) { continue; }

            // Split the comma/space delimited data line (", ")
            String[] lineSplit = line.split(",\\s+"); // \\s+ means 1 or more spaces
            // make sure we have three array elements
            if (lineSplit.length == 3 && userName.equals(lineSplit[1]) && password.equals(lineSplit[2])) {
                loginSuccess = true;
                JFrame frame = new JFrame();
                menu = new MainMenu(lineSplit[0]);
                this.setVisible(false);
                menu.setVisible(true);
                break;
            }
        }
        // Can't find login name or password in file.
        if (!loginSuccess) {
            JOptionPane.showMessageDialog(this, "Invalid User Name or Password!", 
                    "Invalid Login", JOptionPane.WARNING_MESSAGE);
        }
    } 
}