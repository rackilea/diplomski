public String[] OpenFile() throws IOException {
    sp1.setVisible(true);
    String k = t2.getText();
    e = Integer.valueOf(k);
    d = (Math.pow(e, -1)) * (n % 2);
    System.out.println("d=" + d);
    FileReader fr = new FileReader(path);
    BufferedReader br = new BufferedReader(fr);
    String eof_line;
    int numberOfLines = 0;
    while ((eof_line = br.readLine()) != null) {
        arr = eof_line.toCharArray();
        byte_array = eof_line.getBytes();
        for (i = 0; i < byte_array.length; i++) {
            ta1.append(Integer.toString(byte_array[i]));
            double input = byte_array[i];
            double t1 = Math.pow(e, -1);
            double t2 = n % 2;
            double en = (Math.pow(input, e)) * t2;
            p_key = t1 * t2;
            double de = (Math.pow(en, p_key)) * t2;
            b = (char) java.lang.Math.round(de);
            ta2.append("" + b);
            }
            br.close();
            return null;
          }