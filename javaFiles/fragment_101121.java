// open the file once
FileOutputStream ffs = new FileOutputStream ("ps.txt");
PrintStream p = new PrintStream ( ffs );

while (s.hasNextLine()){
    String sentence=s.nextLine();
    int l=sentence.length();
    c++;
    try{//printing P
        for (int i=0;i<l;i++){
            // check "< 48 || > 57", which is non-numeric range
            if ((int)sentence.charAt(i)<48 || (int)sentence.charAt(i)>57){
                p.print(sentence.charAt(i));
            }
        }

        // move to next line in output file
        p.println();
    }   
    catch(Exception e){}
}

p.close();