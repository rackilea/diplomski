int row = 0;
while(fin.hasNextLine()) {                         //while file has more lines
    for(int col = 0; col < candidates; j++) {      //for 'candidates' number of columns
        table[row][col] = fin.nextInt();           //read next integer value and put into table
    }
    row++;                                         //increment row number
}