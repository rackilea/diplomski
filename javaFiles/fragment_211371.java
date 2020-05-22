public aspect ServerLogger {
    pointcut printSomething ();

    before(): printSomething()
    {
            (Master)(thisJoinPointStaticPart.getTarget()).printForAlMethodsInSubClass();
    }
}