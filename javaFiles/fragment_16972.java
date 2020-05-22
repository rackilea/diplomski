public static void main(String[] args) {
    String str = "5588";
    //check if int
    try{
        Integer.parseInt(str);
    }catch(NumberFormatException e){
        //not int
    }
    //check if float
    try{
        Float.parseFloat(str);
    }catch(NumberFormatException e){
        //not float
    }
}