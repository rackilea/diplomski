try {
        //Construct the BufferedWriter object
        bw = new BufferedWriter(new FileWriter(filename));

        //Start writing to the output stream
        for (int i=0; i<accounts.size(); i++) {
          bw.write(accounts.get(i).toString());
          bw.newLine();
        }
    } catch (FileNotFoundException ex) {
        ex.printStackTrace();
    } catch (IOException ex) {
        ex.printStackTrace();
    } finally {
        //Close the BufferedWriter
        try {
            if (bw!= null) {
                bw.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }