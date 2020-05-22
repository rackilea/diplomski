@Around(value = "traceReturnedObjectsFields()")
public Object traceAnotherOne(ProceedingJoinPoint jp) throws Throwable {
    Object res = null;
    res = jp.proceed();
    if (res == null)
        return res;
    Class<?> c1 = res.getClass();
    Field[] fields = c1.getDeclaredFields();
    AccessibleObject.setAccessible(fields, true);
    for (Field field : fields) {
        if (!Modifier.isStatic(field.getModifiers())) {
            System.out.println(field + " = " + field.get(res));
        }
    }
    return res;
}