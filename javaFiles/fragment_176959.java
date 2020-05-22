btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String desktopPath = System.getProperty("user.home") + "/Desktop/";
                try {
                    fw = new FileWriter(desktopPath + "yourfile.txt");
                } catch (IOException ex) {
                    System.out.println("Error : " + ex);
                }
                pw = new PrintWriter(fw);
                pw.println(chckbx_1.isSelected() + "-" + textField.getText() + "-" + chckbx_2.isSelected()
                        + " -" + textField_1.getText());
                if (pw != null) {
                    pw.close();
                }
            }
        });