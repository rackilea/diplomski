String file_path1 = "F:\\CampusImages.txt";
    String file_path2 = "F:\\CampusImageIDs.txt";
    String[] arylines;           

    try{
        ReadFileLocal file = new ReadFileLocal(file_path1);
        aryLines = file.openFile(); 

        int i;
        for (i=0; i<aryLines.length; i++){
            System.out.println(aryLines[i]);
        }       
    }

    catch(IOException e) { 
        System.out.println(e.getMessage()); 
    }


    String all=Arrays.toString(aryLines);  //now arylines is resolved
    WriteFile content = new WriteFile( file_path2, true);
    content.WriteToFile("Write from here: ");
    System.out.println(content);  // Also, is the writing part code righ