XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
    try {
        config.setServerURL(new URL("http://localhost:80"));
        config.setEnabledForExceptions(true);
        config.setEnabledForExtensions(true); //Add this line
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);                           
        Object[] params = new Object[] { new Integer(11), new Integer(3), };
        Integer result = (Integer) client.execute(config,"test.sum", params);
        System.out.println("Results " + result);
    } catch (XmlRpcException exception) {
        System.out.println(exception.getMessage());
        Throwable cause = exception.getCause();
        if(cause != null) {
            if(cause instanceof MyException) {
                System.out.println(((MyException)cause).getMessage());
            }
            else { System.out.println("Cause not instance of Exception."); }
        }
        else { System.out.println("Cause was null."); }
        } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();