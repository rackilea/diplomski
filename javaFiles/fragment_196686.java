ArrayList<String> ids = remove(list);

String matches [] = new String[] {"532","533","534","535","5","537","538","539","540","541"};

for (String b : matches) {

    for (String element : ids) {
        if(element.indexOf(b) > 0 && 
        !Character.isDigit(element.charAt(element.indexOf(b)-1)) && 
        (element.indexOf(b) >= element.length()-b.length() || 
        !Character.isDigit(element.charAt(element.indexOf(b)+b.length())))) {
            System.out.println(element);
        } else {
            System.out.println(">"+element"<-->"+b+"<");
        }
    }            
}