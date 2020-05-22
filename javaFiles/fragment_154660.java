public String replace(String inputStr, char from, char to){
    StringBuffer newString=new StringBuffer();
    for(int i=0;i<inputStr.length();i++){
        if(inputStr.charAt(i)==from){
            newString.append(to);
        }
        else{
            newString.append(inputStr.charAt(i));
        }
    }
    return newString.toString();
}