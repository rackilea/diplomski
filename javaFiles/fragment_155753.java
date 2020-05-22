private boolean checkAddWithMethodSignature(Method method, Class<?> eventType) {
    methodKeyBuilder.setLength(0);
    methodKeyBuilder.append(method.getName());
    methodKeyBuilder.append('>').append(eventType.getName());

    String methodKey = methodKeyBuilder.toString();
    Class<?> methodClass = method.getDeclaringClass();
    Class<?> methodClassOld = subscriberClassByMethodKey.put(methodKey, methodClass);
    if (methodClassOld == null || methodClassOld.isAssignableFrom(methodClass)) {
        // Only add if not already found in a sub class
        return true;
    } else {
        // Revert the put, old class is further down the class hierarchy
        subscriberClassByMethodKey.put(methodKey, methodClassOld);
        return false;
    }
}