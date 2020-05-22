File fileName = new File ("hurricanedata.txt");
Scanner inFile = new Scanner(fileName);


while (inFile.hasNextLine()) {
    index++;
    inFile.nextLine(); // Increments the line of the file that you're reading, so the
                       // next "next()" you call starts at the >next< line of the file.
}
inFile.close();
inFile = new Scanner(fileName); // NOTE: Restarts the Scanner, ensuring that it
                                // starts reading from the beginning of the file again.

hurricaneNames = new String [index];
years = new int [index];
months = new String [index];
pressures = new int [index];
windSpeeds = new int [index];

int i = 0; // NOTE: This should be OUT of the loop, so that i increments
           // and doesn't restart to 0.
while (inFile.hasNext()) {

    years [i] = inFile.nextInt();
    months [i] = inFile.next();
    pressures [i] = inFile.nextInt();
    windSpeeds [i] = inFile.nextInt();
    hurricaneNames [i] = inFile.next();
    System.out.println(years[i]);  //print statement to test
    i++;
}