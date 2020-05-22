String line;
int errorCount=0;
String[] strArr;
try{
    BufferedReader br = new BufferedReader(new FileReader(yourTextFile));
    while((line = br.readLine()) != null){
        strArr = line.split(":");
        if(strArr.length==4){
            if(strArr[0].trim().isEmpty()) errorCount++;
            if(strArr[1].trim().isEmpty()) errorCount++;
            if(strArr[2].trim().indexOf("x")>=0) errorCount++;
            if(strArr[3].trim().indexOf("x")>=0) errorCount++;
        }
        else errorCount++;
    }
}
catch(Exception e){
    //error handling
}
System.out.println("Error count: "+errorCount);