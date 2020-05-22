public static void compress(String in, String out) throws IOException
{
    try 
        {
            File outFile = new File(out);
            FileOutputStream compressedFile = new FileOutputStream(outFile);

            // 1. Use a Reader instead of a Scanner;
            // make sure to use the correct charset
            FileInputStream fis= new FileInputStream(in);
            Reader reader = new InputStreamReader(fis,        
                Charset.forName("US-ASCII"));

            // use BufferedReader for even better performance
            Reader bufferedReader = new BufferedReader(reader);

            int r;
            while ((r = bufferedReader.read()) != -1) {
                char ch= (char) r;

                // 2. Get the string for this character directly instead of
                // looping the keySet and checking for equivalence
                String s= table.get(ch);
                if (s != null) {
                    // 3. Write entire array of bytes instead of 
                    // looping and writing bytes one by one
                    compressedFile.write(s.getBytes());
                }
            }
            fis.close();
            compressedFile.close();
        }
    ...