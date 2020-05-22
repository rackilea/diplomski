/**
     * This will cast an {@link ADBBean} implementation to another
     * {@link ADBBean}, but the Implementation will be a subClass of
     * <b>parentLocationOfSourceClass</b>.<br>
     * This only is possible because of the structure of all ADBBean
     * implementations created by <code>Axis2 ADB-Databinding</code>. If you
     * cange the Databinding you probably have to adapt this Method.
     * 
     * @param inputADBBean
     *            An ADBBean Implementation created by
     *            <code>Axis2 ADB-Databinding</code>
     * @param parentLocationOfSourceClass
     *            This is meant to be the <code>ClientStub</code> Class created
     *            by <code>Axis2 ADB-Databinding</code>. The Implementation of
     *            the <code>inputADBBean</code> has to be available with the
     *            same name in the <code>ClientStub</code>
     * @return An {@link ADBBean} implementation defined as SubClass of the
     *         <code>ClientStub</code> Class created by
     *         <code>Axis2 ADB-Databinding</code>
     * @throws Exception
     */
    public static ADBBean castADBBean(ADBBean inputADBBean, String parentLocationOfSourceClass) throws Exception {
        Class clazz = CallbackResponsePoolClient.getClassForParentLocation(inputADBBean, parentLocationOfSourceClass);
        ADBBean outputADBBean = CallbackResponsePoolClient.getInstanceForADBBean(clazz);
        for (Method method : outputADBBean.getClass().getMethods()) {
            String methodName = method.getName();
            if (methodName.startsWith("set")) {
                CallbackResponsePoolClient.logger.debug("Found a setter: " + methodName);
                String getterName = methodName.replaceFirst("set", "get");
                Object arg = inputADBBean.getClass().getMethod(getterName).invoke(inputADBBean);
                // We need to check if arg lives in the namespace:
                // org.example.www.callbackresponsepoolinterface
                // This will happen if we have nested Objects. E.g.
                // EndpointType inside of EndpointResponse
                // TODO: instanceof ADBBean could lead to problems, maybe
                // sometimes we don't want to cast an ADBBean, but I can't think
                // a scenario right now
                if (arg instanceof ADBBean) {
                    arg = CallbackResponsePoolClient.castADBBean((ADBBean) arg, parentLocationOfSourceClass);
                }
                // We also need to handle Arrays of ADBBeans. See above
                if (arg instanceof ADBBean[]) {
                    Class innputClass = ((ADBBean[]) arg).getClass().getComponentType();
                    // Better Create a new Object, because arg[0], can get you
                    // an Exception for an empty Array
                    ADBBean inputArrObj = CallbackResponsePoolClient.getInstanceForADBBean(innputClass);
                    Class outputArrClass = CallbackResponsePoolClient.getClassForParentLocation(inputArrObj, parentLocationOfSourceClass);
                    Object outputArray = Array.newInstance(outputArrClass, ((ADBBean[]) arg).length);
                    for (int i = 0; i < Array.getLength(arg); i++) {
                        Array.set(outputArray, i, CallbackResponsePoolClient.castADBBean((ADBBean) Array.get(arg, i), parentLocationOfSourceClass));
                    }
                    arg = outputArray;
                }

                method.invoke(outputADBBean, arg);
            }
        }

        return outputADBBean;
    }

    private static Class getClassForParentLocation(ADBBean inputADBBean, String parentLocationOfSourceClass) throws ClassNotFoundException {
        return Class.forName(parentLocationOfSourceClass + "$" + inputADBBean.getClass().getSimpleName());
    }

    private static ADBBean getInstanceForADBBean(Class clazz) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Constructor constructor = clazz.getConstructor();
        return (ADBBean) constructor.newInstance();
    }