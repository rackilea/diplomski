public static HashMap<String, String> getEnvVariables(String scriptFile,
            String config) {
        HashMap<String, String> vars = new HashMap<String, String>();
        BufferedReader br = null;
        try {
            FileInputStream fstream = new FileInputStream(scriptFile);
            br = new BufferedReader(new InputStreamReader(fstream));
            String strLine = null;
            String stopvar = "HDK7564";
            String startvar = "HDK1001";
            String keyword = "export";
            do {
                if (strLine != null && strLine.contains(startvar)) {
                    if (strLine.contains(stopvar)) {
                        return vars;
                    }
                    while (strLine != null && !strLine.contains(stopvar)) {
                        strLine = br.readLine();
                        if (strLine.startsWith(keyword)) {
                            strLine = strLine.substring(keyword.length())
                                    .trim();
                            String[] split = strLine.split("=");
                            String name = split[0];
                            String value = split[1];
                            System.out.println(name + "=" + value);
                            vars.put(name, value);
                        }
                    }
                }
            } while ((strLine = br.readLine()) != null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vars;
    }