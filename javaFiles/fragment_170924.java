try {
Method method = emRequestResponse.getDeclaredMethod("method name", parameterTypes);
method.invoke(objectToInvokeOn, params);
} catch(Exception ex) {
System.out.println(ex.toString());
}