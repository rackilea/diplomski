ProcessBuilder b1 = new ProcessBuilder("cmd.exe", "/c", "cd \"C:\\elk\\logstash-5.1.2\\bin\" && logstash -f first-pipeline.conf --config.reload.automatic");
        b1.redirectErrorStream(true);
        Process p1 = b1.start();
        BufferedReader r1 = new BufferedReader(new InputStreamReader(p1.getInputStream()));
        String line1;
        while (true) {
            line1 = r1.readLine();
            if (line1 == null) { break; }
            System.out.println(line1);
        }