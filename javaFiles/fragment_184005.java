//Create an new File with the customer name
       File file2 = new File(customer.getName()+".txt"); //make sure you enter the right path
        if (!file2.exists()) {
            file2.createNewFile(); //create the file if it doesn't exist
        }

        FileWriter fw = new FileWriter(file2.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(newFile); // write the new Content to our new file 
        bw.close();