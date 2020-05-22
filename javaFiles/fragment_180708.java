public String startOz(String str) 
{
    if (str.length() <= 1) {         
        return str;          
    } else if (str.substring(0, 1).equals("o")) {    
        if (str.substring(1, 2).equals("z")) {
            return "oz";
        } else {
            return "o";
        }
    } // no return value 
}