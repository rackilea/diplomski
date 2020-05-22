@Before("@annotation(annotation)")
public void registerTransactionSynchronization(final JoinPoint jp, final Transactional annotation) {

    // These are the method parameters, yours would be at parameters[0], but check first... ;)
    final Object[] parameters = jp.getArgs(); 

    // Your stuff here       
}