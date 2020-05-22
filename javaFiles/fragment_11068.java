public void actionPerformed(ActionEvent arg0) {
    String line;
    JFileChooser fileload = new JFileChooser();
        if (fileload.showOpenDialog(Main.this) == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fileload.getSelectedFile();
                FileInputStream fis = new FileInputStream(file);
                reader = new BufferedReader(new FileReader(file));
                Object[] tableRow = new Object[columnNames.length];
                int column = 0;
                while ((line = reader.readLine()) != null) {
                    tableData[column++] = line.split(": ")[1];
                    if (column > 3) {
                        tableModel.addRow(tableRow);
                        column = 0;
                    }
                }
                reader.close();
             } catch (IOException e10) {
                  JOptionPane.showMessageDialog(null, "Buffered Reader issue.");
             }
        }
    };