return () -> {
    try {
       method2(parameter1, parameter2...);
    } catch (final CloneNotSupportedException e) {
       throw YourCustomRuntimeException("Error while cloning", e /* Original cause */);
    }
};