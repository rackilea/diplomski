XWPFDocument xwpfDocument = new XWPFDocument();
                File file = new  File("hello.docx");
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    } 
                }
                try {
                    xwpfDocument.write(new FileOutputStream(file));
                } catch (FileNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }