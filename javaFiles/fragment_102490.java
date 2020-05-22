XmlRpcClient client = new XmlRpcClient("http://www.upcdatabase.com/xmlrpc", false);
    Map<String, String> params = new HashMap<String, String>();
    params.put("rpc_key", rpc_key);
    params.put("ean",upc);

    HashMap<?,?> token = null;
    try {
        token = (HashMap<?, ?>) client.invoke( "lookup", new Object[] { params } );
    } catch (XmlRpcException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (XmlRpcFault e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }