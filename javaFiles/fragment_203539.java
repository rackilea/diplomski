Scanner inputFile = new Scanner(new File("inputfile.txt"));
while(inputFile.hasNext()){ //if there is still something to read
     String name = inputFile.next();
     int score1 = inputFile.nextInt();    
     ....
     int score5 = inputFile.nextInt();
     //Do something here with the scores
     inputFile.next(); //Read the new line character and prepare for the next iteration 
}