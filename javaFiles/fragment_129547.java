pointcut auditField(Object t, Object value, CaptureChanges captureChanges): 
    set(* *) && @annotation(captureChanges) && args(value) && target(t);

before (Object target, Object newValue, CaptureChanges captureChanges): 
        auditField(target, newValue, captureChanges) {

    FieldSignature sig = (FieldSignature) thisJoinPoint.getSignature();
    Field field = sig.getField();
    field.setAccessible(true);
    Object oldValue;
    try {
        oldValue = field.get(target);
    } catch (IllegalAccessException e) {
        throw new RuntimeException("Failed to create audit Action", e);
    }
    System.out.println("changed from " + oldValue + " to " + newValue 
            + ", fieldType=" + captureChanges.fieldType()
            + ", fieldChangeType=" + captureChanges.fieldType().getType());
}