public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        if (management == null)
        {
            management = ManagementClientStore.getInstance().getManagementClient(msConfig.getHost(),
                    msConfig.getAdminPort(), msConfig.getUser(), msConfig.getPassword(), false);
        }

        final Object result =  management.methodCall(mbeanName, method.getName(), args ==  null?  new Object[] {} : args);
        return result;
    }