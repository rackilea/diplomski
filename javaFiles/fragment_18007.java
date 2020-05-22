ActionListener l = new ActionListener(){
    public void actionPerformed(ActionEvent ae){
        try {
            BufferedReader in = new BufferedReader(new FileReader("foo.txt"));
            StringBuffer sb = new StringBuffer();
            char[] buf = new char[4096];
            int n;
            while (-1 != (n = in.read(buf))){
                sb.append(buf, 0, n);
            }
            in.close();
            String s = sb.toString();
            jTextPane1.setText(s);
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

    }
};
jButton1.addActionListener(l);