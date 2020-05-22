public void readFromFile(String fileName, ListInterface<User> userList) {
        String oneLine, oneLine2;
        User user;
        try {
            /*
             * Create a FileWriter object that handles the low-level details of
             * reading
             */
            FileReader theFile = new FileReader(fileName);

            /*
             * Create a BufferedReader object to wrap around the FileWriter
             * object
             */
            /* This allows the use of high-level methods like readline */
            BufferedReader fileIn = new BufferedReader(theFile);

            /* Read the first line of the file */
            oneLine = fileIn.readLine();
            /*
             * Read the rest of the lines of the file and output them on the
             * screen
             */
            while (oneLine != null) /* A null string indicates the end of file */
            {
                oneLine2 = fileIn.readLine();
                user = new User(oneLine, oneLine2);
                oneLine = fileIn.readLine();
                userList.append(user);
            }

            /* Close the file so that it is no longer accessible to the program */
            fileIn.close();
        }

        /*
         * Handle the exception thrown by the FileReader constructor if file is
         * not found
         */
        catch (FileNotFoundException e) {
            System.out.println("Unable to locate the file: " + fileName);
        }

        /* Handle the exception thrown by the FileReader methods */
        catch (IOException e) {
            System.out.println("There was a problem reading the file: "
                    + fileName);
        }
    } /* End of method readFromFile */


    public void writeToFile(String fileName, ListInterface<User> userList) {
        try {
            /*
             * Create a FileWriter object that handles the low-level details of
             * writing
             */
            FileWriter theFile = new FileWriter(fileName);

            /* Create a PrintWriter object to wrap around the FileWriter object */
            /* This allows the use of high-level methods like println */
            PrintWriter fileOut = new PrintWriter(theFile);

            /* Print some lines to the file using the println method */
            for (int i = 1; i <= userList.size(); i++) {
                fileOut.println(userList.get(i).getUsername());
                fileOut.println(userList.get(i).getPassword());
            }
            /* Close the file so that it is no longer accessible to the program */
            fileOut.close();
        }

        /* Handle the exception thrown by the FileWriter methods */
        catch (IOException e) {
            System.out.println("Problem writing to the file");
        }
    } /* End of method writeToFile */