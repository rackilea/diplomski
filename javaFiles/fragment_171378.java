// Ex 3 : 
class RunnableFactory {
    public static Runnable makeRunnable() {
        return new MyJob(); // which is a Runnable, see above
    }
}
executeInParallel( () -> RunnableFactory.makeRunnable() );
executeInParallel( RunnableFactory::makeRunnable );