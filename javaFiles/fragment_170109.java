public static void main(String[] args){
    try
    {
        logger.info("Test");
        logger.error("TEST!");
        someMethodThatPropablyThrowsAnException();
        throw new IllegalArgumentException("Exception");
    }
    catch (Exception exception)
    {
        logger.error(exception);
    }
}