String line = null;
int userLine=0;
LineNumberReader lnr = new LineNumberReader(new FileReader("src/BioStat/username.txt"));
while((line=lnr.readLine())!=null){
    if(line.equals(username)){
        //username is found in username list. There is a match!
        //let's get it's line number
        userLine = lnr.getLineNumber();
        break;
    }
}
lnr.close();