try {
                File file = new File(fileName);
                if (!file.exists()) {
                    file.createNewFile();
                }

                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);

                String text = textArea.getText();
                textArea.setText("");
                Scanner scanner = new Scanner(text);

                while (scanner.hasNextLine()) {

                    String line = scanner.nextLine();
                    byte[] utf8 = line.getBytes("UTF-8");
                    line = new String(utf8, "UTF-8");

                    bw.write(line);
                    System.out.println(line);
                }

            }

            catch (Exception e) {
                System.out.print(e.getMessage());
            } finally {
                try {
                    bw.close();
               } catch (Exception e) {
                System.out.print("Exception while closing the bw");
               }
            }