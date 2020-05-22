try {
        final Object instance = getterMethodField.getDeclaringClass().newInstance();
        getterMethodField.set(instance, "");
    } catch (final Exception e) {
        e.printStackTrace();
    }

    return methodToInvoke.invoke(instance, args);
}