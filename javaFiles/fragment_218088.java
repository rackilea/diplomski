public void deleteRecord() { 
        String filePath = "marks.txt";
        System.out.println("Enter the StudentID of the record you wish to delete: ");
        Scanner in = new Scanner(System.in);
        String removeTerm = in.nextLine();
        String tempFile = "temp.txt";
        File oldFile = new File(filePath);
        File newFile = new File(tempFile);

        try {
            FileWriter fw = new FileWriter(tempFile,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            BufferedReader reader = new BufferedReader(new FileReader(oldFile);

            String line = "";
            while((line = reader.readLine()) != null) {
              if(!line.startsWith(removeTerm)) {
                pw.println(line);
              }
            }
            reader.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump = new File(filePath);
            newFile.renameTo(dump);
            System.out.println("Record successfully deleted.");

        } catch(IOException e) {
            System.out.println("Error has occured.");

        }
    }