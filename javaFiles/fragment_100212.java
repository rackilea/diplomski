try {
        Scanner s = new Scanner(recordedFiles);
        recordedFilesArray = new ArrayList<String>();
        while (s.hasNextLine()){
            recordedFilesArray.add(s.nextLine());
        }

    } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }finally{
        s.close(); //close file on success or error
    }