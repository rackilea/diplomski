SQL sql = null;
try {
    sql = (SQL) MethodUtils.invokeExactMethod(bean, "getSQL", (Object[])null);
} catch (Exception e) {
    e.printStackTrace();
}