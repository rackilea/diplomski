String className = ...;
String methodName = ...;
Class[] methodParamTypes = ...;
Object[] methodParams = ...;
Class cl = Class.forName(className);
Method me = cl.getDelcaredMethod(methodName, methodParamTypes);
Object returnValue = me.invoke(this, methodParams);