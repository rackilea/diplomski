public void methodName(Object input){
    try{
        Method method = input.getClass().getMethod("GetItNow");
        RETURN_TYPE returnValue = (RETURN_TYPE)method.invoke(input);
    }catch(Exception e){
        throw new RuntimeException("Error while invoking method",e);
    }
}