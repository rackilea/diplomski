Class[] types = new Class[inputParams.size()];
int i = 0;
for(Object param:inputParams) {
    types[i++] = param.getClass();
}
Method calledMethod = classObj.getClass().getMethod(methodName,types);
Object returnVal = calledMethod.invoke(classObj,inputParams.toArray());