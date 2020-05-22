line = bufferedReader.readLine();
CardNum = line.split("\\s+");
do{
    for(Counter = 0; Counter < CardNum.length; Counter++){
        LineNo = CardNum[Counter];
        if(LineNo.contains(CardNumberStr)){
            Exist = true;
            System.out.println("I've found it!");
        }
        else if(Counter == CardNum.length){
            Exist=false;
        }
    }
    //add this line to read another line of the file
    //and check if it exists
    line = bufferedReader.readLine();
} while(!Exist && line != null);