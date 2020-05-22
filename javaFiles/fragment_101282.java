public void correctListItems(FileInputStream inputFile,FileOutputStream outputFile){

    newInput = new Scanner(inputFile);


    int aNumber = numOfObjects(newInput); 
    newInput.close();
    inputFile.close();
    inputFile = new FileInputStream(
            new File(
                    "inputfile.txt"));
    System.out.println(aNumber); 
    forCapturing = new Scanner(inputFile);
    for(int i=0; forCapturing.hasNextLine(); i++){ 
    ....
    ....