String line = null;
while ((line = buff.readLine()) !=null) {
    try {
        instatiateAndUseJSONParser;
        if (line.matches(DELETE_REGEX)) {
            doSomeStuff;
        }
    } 
    catch (AllTheExceptions e){
        throw new RuntimeException(e);
    }
}