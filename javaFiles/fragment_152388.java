public void addItem() {
    String url="https://www.aspiresoft.ke/Wt/webtask.asmx";
    String soap_action="http://tempuri.org/AddItem";
    String method_name="AddItem";
    String nameSpace="http://tempuri.org";

    SoapObject soapObject=new SoapObject(nameSpace,method_name);
    soapObject.addProperty("UserName",strName);
    soapObject.addProperty("ItemCode",strItemCode);
    soapObject.addProperty("Description",strDescription);
    soapObject.addProperty("Packaging",strPackage);
    soapObject.addProperty("Unit",strUnits);
    soapObject.addProperty("Photo",strPhoto);

    //configuring soap version
    SoapSerializationEnvelope envelope=new SoapSerializationEnvelope(SoapEnvelope.VER11);
    //specify true when you are calling dotnet WS(.asmx)
    envelope.dotNet=true;
    envelope.setOutputSoapObject(soapObject);

    //setting soap header
    envelope.headerOut = new Element[1];
    envelope.headerOut[0] = buildAuthHeader(nameSpace);


    //transfer request over the network
    HttpTransportSE httpsTranSE=new HttpTransportSE(url);
    try{
        httpsTranSE.call(soap_action,envelope);
        envelope.getResponse();
        SoapObject object=(SoapObject) envelope.bodyIn;
        String response=object.getProperty(0).toString();
        System.out.println(response);
    }catch (Exception e){
        e.printStackTrace();
    }
}

//Header
private Element buildAuthHeader(String nameSpace) {
        Element h = new Element().createElement(nameSpace, "AuthHeader");
        Element username = new Element().createElement(nameSpace, "userName");
        username.addChild(Node.TEXT, "1234");
        h.addChild(Node.ELEMENT, username);
        Element pass = new Element().createElement(nameSpace, "password");
        pass.addChild(Node.TEXT, "4321");
        h.addChild(Node.ELEMENT, pass);
        return h;
    }