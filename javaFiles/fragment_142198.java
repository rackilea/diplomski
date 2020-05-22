public class JpaOptimisticLockingFailureException extends ObjectOptimisticLockingFailureException {

    public JpaOptimisticLockingFailureException(OptimisticLockException ex) {
        super(ex.getMessage(), ex);
    }

}