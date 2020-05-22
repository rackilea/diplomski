String inputString = "Hi Amod. Your registration number is AX1234 and hallticket number is XC876";
    Pattern p = Pattern.compile("[A-Z]{2}\\d+");
    Matcher m = p.matcher(inputString);
    String [] values = new String[2];
    int i=0;
    Map<String,String> map = new HashMap<>();
    while (m.find()) {
        values[i++] = m.group();
    } 
    if(inputString.indexOf("registration")<inputString.indexOf("hallticket")){
        map.put("registration", values[0]);
        map.put("hallticket", values[1]);
    }
    else{
        map.put("registration", values[1]);
        map.put("hallticket", values[0]);
    }
    for(Entry e: map.entrySet()){
        System.out.println(e.getKey() +" : "+e.getValue());
    }