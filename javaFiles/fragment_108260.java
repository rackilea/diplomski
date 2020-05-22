private static File filelocation = null;

private static void test() {
    load_exe.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            // Check if file-name to execute has already been set
            if (filelocation != null) {
                try {
                    JFileChooser file_Choose = new JFileChooser();

                    file_Choose.showOpenDialog(frame);
                    JavaSamp.filelocation = file_Choose.getSelectedFile();
                    System.out.println("FileLocation"
                            + JavaSamp.filelocation.getAbsolutePath());
                } catch (Exception expobj) {
                }
            }
            Runtime rt = Runtime.getRuntime();

            try {
                System.out.println("File Run Location"
                        + JavaSamp.filelocation.getAbsolutePath());
                Process proc = rt.exec(JavaSamp.filelocation
                        .getAbsolutePath());

            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }
    };
}