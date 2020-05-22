public static String extractString(String input) {

        String regEx ="(.*)([ ]*\\d{4}-\\d{2}-\\d{2}[\\s|T]\\d{2}:\\d{2}:\\d{2}(?:(?:[,.]{1}\\d{0,3})|(?:[Z]{1}))[ ]*)(.*)";
        Matcher matcher = Pattern.compile(regEx).matcher(input);            

        String output="";
        if(matcher.matches()) { 
            output= matcher.group(1)+matcher.group(3);              
        }else {
            output=input;
        }   

        return output.trim();
 }