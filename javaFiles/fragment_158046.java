InputStream is = new FileInputStream("utf8_encoded_text.txt");
        OutputStream os = new FileOutputStream("gb2312_encoded.txt");

        Reader r = new InputStreamReader(is,"utf-8");
        BufferedReader br = new BufferedReader(r);
        Writer w = new OutputStreamWriter(os, "gb2312");
        BufferedWriter bw = new BufferedWriter(w);

        String s=null;
        while((s=br.readLine())!=null) {
            bw.write(s);
        }
        br.close();
        bw.close();
        os.flush();