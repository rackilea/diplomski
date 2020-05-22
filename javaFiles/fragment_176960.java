btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String desktopPath = System.getProperty("user.home") + "/Desktop/";
                try {
                    String sCurrentLine;
                    br = new BufferedReader(new FileReader(desktopPath + "yourfile.txt"));
                    while ((sCurrentLine = br.readLine()) != null) {
                        StringTokenizer tokenizer = new StringTokenizer(sCurrentLine, "-");
                        if (tokenizer.hasMoreElements()) {
                             Boolean boolean1 = Boolean.valueOf(tokenizer.nextToken());
                             chckbx_1.setSelected(boolean1);
                        }
                        if (tokenizer.hasMoreElements()) {
                            textField.setText(tokenizer.nextToken());
                        }
                        if (tokenizer.hasMoreElements()) {
                             Boolean boolean1 = Boolean.valueOf(tokenizer.nextToken());
                             chckbx_2.setSelected(boolean1);
                        }
                        if (tokenizer.hasMoreElements()) {
                            textField_1.setText(tokenizer.nextToken());
                        }

                    }
                } catch (FileNotFoundException ex) {
                    System.out.println("Error : " + ex);
                } catch (IOException ex) {
                    System.out.println("Error : " + ex);
                }
            }
        });