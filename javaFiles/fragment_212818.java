Runtime runtime = Runtime.getRuntime();
    String[] cmd = { "C:\\Users\\dev\\Documents\\projects\\projectx_solution\\java\\projectx\\build\\bin\\squeezer",
            "-R",
            "1",
            "C:\\Users\\dev\\Documents\\work\\w1\\SPOH_ANO12_PDC2.fast",
            "-L",
            "c:\\Users\\dev\\Documents\\jira\\work\\ABC04214017-long-path-qwertyuioplkjhgfdsazxcvbnm\\qwertyuioplkjhgfdsazxcvbnm2\\qwertyuioplkjhgfdsazxcvbnm3\\qwertyuioplkjhgfdsazxcvbnm-qwertyuioplkjhgfdsazxcvbnm4\\qwertyuioplkjhgfdsazxcvbnm5\\qwertyuioplkjhgfdsazxcv\\qwertypoiuyalskdjfhg\\ABC04214017_03.raw_fhhzcqaj_wLM(4)\\objs\\RemPartic.fast",
            "-H",
            "100000"
    };

    Process process = runtime.exec(cmd);
    InputStream in = process.getInputStream();

    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
    String line;

    while ((line = reader.readLine()) != null) {
        System.out.println(line);
    }