private int checkService(String service) {
    int s = 0;
    try {
        Process p = Runtime.getRuntime().exec("sc query " + service);

        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

        String line = reader.readLine();
        while (line != null) {
            if (line.trim().startsWith("STATE")) {
                switch (line.trim().substring(line.trim().indexOf(":") + 1,     line.trim().indexOf(":") + 4).trim()) {
                    case "1":
                        s = 0;
                        break;
                    case "2":
                        s = 3;
                        break;
                    case "3":
                        s = 2;
                        break;
                    case "4":
                        s = 1;
                        break;
                }
            }
            line = reader.readLine();
        }

    } catch (IOException e1) {
        System.out.println(e1);
    }
    return s;
}