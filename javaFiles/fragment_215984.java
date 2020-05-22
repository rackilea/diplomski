else if (OS.contains("linux")) {
        try {

            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec("netstat -nlp | grep :9090");

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String s = null;
            StringBuilder sb = new StringBuilder();
            String sc = null;
            while ((s = stdInput.readLine()) != null) {
                if (s.contains("9090")) {
                    sb.append(s);
                    System.out.println(s);

                    String process = s.trim();
                    int index = process.lastIndexOf(" ");
                    int to = process.indexOf("/");

                    sc = s.substring(index, to);

                }

                rt.exec("kill -9 " + sc);
            }}