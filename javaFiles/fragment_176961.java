btn2.addActionListener(new ActionListener() {
                @Override
                    public void actionPerformed(ActionEvent e) {
                        JFileChooser fc = new JFileChooser();
                        int ret = fc.showOpenDialog(null);
                        if (ret == JFileChooser.APPROVE_OPTION) {
                            File file = fc.getSelectedFile();
                             filename = file.getAbsolutePath();
                        }
....