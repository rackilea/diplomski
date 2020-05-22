CloudServiceSoapStub stub=null;
    CloudServiceLocator locator=new CloudServiceLocator();
    String endPointAddress = locator.getServiceSoapAddress();

    try {
        stub=(CloudServiceSoapStub) locator.getServiceSoap(new URL(endPointAddress));
    } catch (MalformedURLException e) {
        e.printStackTrace();
    } catch (ServiceException e) {
        e.printStackTrace();
    }