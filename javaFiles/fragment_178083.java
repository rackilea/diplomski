String separator = System.getProperty( "line.separator" );
                 BufferedReader br;
                 String line;
                 InputStream fis = null;
                 File file = new File("C:\\junk\\out.txt");
                    // if file doesnt exists, then create it
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                 FileWriter fw = new FileWriter(file.getAbsoluteFile());
                 BufferedWriter bw = new BufferedWriter(fw);

                 try
                 {
                     //your input file
                     fis = new FileInputStream("C:\\junk\\test.txt");
                     br = new BufferedReader( new InputStreamReader(fis, Charset.forName("UTF-8")));
                     while((line = br.readLine())!=  null)
                     {
                         System.out.println(line);
                         String result[] = line.split(" ");
                         String word = result[0];
                         bw.write(word);
                         bw.write(separator);
                     }    
                 }

                 catch(Exception e)
                 {
                     System.out.println(e);
                 }

                 finally
                 {
                     try
                     {
                         //close the files
                         fis.close();
                        bw.close();
                     }
                     catch(IOException ie)
                     {
                         System.out.println(ie);
                     }
                 }