int totalLines = 0;

          BufferedReader br   br = new BufferedReader(new   FileReader("C:\\filename.txt"));
                String  CurrentLine = "";
                while ((CurrentLine = br.readLine()) != null) {
                    ++totalLines
                }