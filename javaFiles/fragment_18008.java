final Runnable r = new Runnable() {
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new FileReader("foo.txt"));
            StringBuffer sb = new StringBuffer();
            char[] buf = new char[4096];
            int n;
            while (-1 != (n = in.read(buf))) {
                sb.append(buf, 0, n);
            }
            in.close();
            final String s = sb.toString();
            EventQueue.invokeLater(new Runnable(){
                public void run(){
                    jTextPane1.setText(s);
                }
            });
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
};
ActionListener l = new ActionListener(){
    public void actionPerformed(ActionEvent ae){
        new Thread(r).start();
    }
};
jButton1.addActionListener(l);