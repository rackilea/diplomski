List<String> list = new ArrayList<String>();
String str="";
while(s.hasNext()){
    if(s.hasNextInt()){
        str+=s.nextInt()+" ";                                   
    }
    else {                          
        String tmpData = s.next();
        String pattern = ".*?(\\d+).*";
        if(tmpData.matches(pattern)){
            String firstNumber = tmpData.replaceFirst(".*?(\\d+).*", "$1");         
            str+=firstNumber;
            list.add(str);
            str="";
            str+=tmpData.replace(firstNumber, "")+" ";                                                  
        }else{
            str+=tmpData;
        }               
    }           
}
list.add(str);
System.out.println(list);