String inputCSVFile = "/input_folder_path/sample.csv"; 
        BufferedReader bufferedReader = null;
        String lines = "";
        String splitChar = ",";        
        String[] columns;

        int count = 0;

        try {

            PrintStream printStream = new PrintStream(new FileOutputStream("/output_folder_path/e.ldif"));// Step 1
            bufferedReader = new BufferedReader(new FileReader(inputCSVFile));

            while ((lines = bufferedReader.readLine()) != null) {


                columns = lines.split(splitChar);// Step 2


                if (count > 0) {// Step 3 ,4
                    printStream.println("dn: cn="+columns[1]+", ou="+columns[2]+", o=Data"
                            + "\ngivenName: "+columns[0]
                            + "\nsn: "+columns[3]
                            + "\n"
                    );
                }
                count++;

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }