int id = myScanner.nextInt();
String title = myScanner.next();

//while title has more words
while(!myScanner.hasNextInt()){
   //append words with whitespace
   title = title + " " + myScanner.next();
}

int likes = myScanner.nextInt();