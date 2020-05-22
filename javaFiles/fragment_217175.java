JMenuItem menuOpenFile = new JMenuItem("Open File");
menuOpenFile.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent arg0) {
        JFileChooser chooser = new JFileChooser();
        switch (chooser.showOpenDialog(frame)) {
        case JFileChooser.APPROVE_OPTION:
            File file = fileChooser.getSelectedFile();
            TxtParser txtParser = new TxtParser();

            try {
            taxpayer = txtParser.parse(file);
            if (taxpayer == null) {
                System.out.println("NULL TAXPAYER");
            }
            System.out.println(taxpayer);
            setTextpayerInfo(taxPayer);
            } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
            }
            break;
        }
    }
});