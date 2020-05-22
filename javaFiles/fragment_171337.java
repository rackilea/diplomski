public interface CacheOperationInvocationContext<O extends BasicOperation> {
    O getOperation();
    Object getTarget();
    Method getMethod();
    Object[] getArgs();
}