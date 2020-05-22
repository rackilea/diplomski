int value1 = -1; // -1 just to give it an initial value
int value2 = -1;
boolean eof1 = !scanFile1.hasNextInt();
booelan eof2 = !scanFile2.hasNextInt();
if(!eof1){
    value1 = scanFile1.nextInt();
} 

if(!eof2){
    value2 = scanFile2.nextInt();
}
while (!eof1 && !eof2) {

        if (value1 < value2) {
            // The number in fileName1 is less
            writeToFile.write(value1 + "");
            writeToFile.write(System.getProperty("line.separator"));
            eof1 = !scanFile1.hasNextInt();
            if(!eof1){
                value1 = scanFile1.nextInt();
            }

        } else if(value1 > value2){ // The number in fileName2 is less
            writeToFile.write(value2 + "");
            writeToFile.write(System.getProperty("line.separator"));
            eof2 = !scanFile2.hasNextInt();
            if(!eof2){
                value2 = scanFile2.nextInt();
            }
        }else{ // they are equal
            writeToFile.write(value1 + "");
            writeToFile.write(System.getProperty("line.separator"));
            eof1 = !scanFile1.hasNextInt();
            if(!eof1){
                value1 = scanFile1.nextInt();
            }
            eof2 = !scanFile2.hasNextInt();
            if(!eof2){
                value2 = scanFile2.nextInt();
            }
        }
    }