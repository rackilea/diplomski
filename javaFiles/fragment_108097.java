try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
                InputStream in = p.getInputStream()) {
            in.read();
            bw.write("1");
            bw.newLine();
            bw.flush();
            bw.write("2");
            bw.newLine();
            bw.flush();
        }