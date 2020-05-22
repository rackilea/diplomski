if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
        //get the selected file
        java.io.File file = chooser.getSelectedFile();
        try {
            //create scanner for the file
            Scanner input = new Scanner(file);
            //read text from file
            while (input.hasNext()) {
                System.out.println(input.nextLine());
            }
            //close the file
            input.close();
        } catch (FileNotFoundException fnfe) {
            // handle exception here, e.g. error message to the user
        }
    } else {
        System.out.println("No file selected");
    }