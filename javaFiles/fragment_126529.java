private static int isValidQuantity(String aQuantity){
    int result = 0;
    //first try int
    try{
        Integer.parseInt(aQuantity);
        result = 1; //the parse worked
    }catch(NumberFormatException ex){
        result = 0;
    }

    if(result == 0)
    {
        //if it's not an int then try double
        try{
            Double.parseDouble(aQuantity);

            result = 2; //the parse worked
        }catch(NumberFormatException ex){
            result = 0;
        }
    }

    return result;
}