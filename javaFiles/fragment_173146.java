//you will problably need to tune up a bit the du command
        String[] cmd = {
        "/bin/sh", "-c", "du -h /home/user/me/*.txt" };//to get all the txt files size in folder

        try {
            Process p = Runtime.getRuntime().exec(cmd);
            BufferedReader bri = new BufferedReader(new InputStreamReader(
                    p.getInputStream()));

            String line = "";
            while ((line = bri.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {

            e.printStackTrace();
        }