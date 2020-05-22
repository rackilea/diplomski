public static String identifyCommonSubStrOfNStr(String [] strArr){

    String commonStr="";
    String smallStr ="";        

    //identify smallest String      
    for (String s :strArr) {
        if(smallStr.length()< s.length()){
            smallStr=s;
        }
    }

    String tempCom="";
    char [] smallStrChars=smallStr.toCharArray();               
    for (char c: smallStrChars){
        tempCom+= c;

        for (String s :strArr){
            if(! s.contains(tempCom)){
            tempCom="";
                break;
            }               
        }

        if(tempCom!="" && tempCom.length()>commonStr.length()){
            commonStr=tempCom;  
        }                       
    }   

    return commonStr;
}