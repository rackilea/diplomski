<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
    <%
        SR_spcWeb_spcService srv = new UNINServiceRequestWSLocator().getSR_spcWeb_spcService(new java.net.URL("https://crmsit.un.org/eai_enu/start.swe?SWEExtSource=WebService&SWEExtCmd=Execute&WSSOAP=1"));
        ((SR_spcWeb_spcServiceStub) srv).setUsername("username");
        ((SR_spcWeb_spcServiceStub) srv).setPassword("password");
        ((SR_spcWeb_spcServiceStub) srv).setHeader("http://siebel.com/webservices", "UsernameToken", "username");
        ((SR_spcWeb_spcServiceStub) srv).setHeader("http://siebel.com/webservices", "PasswordText", "password");
        ((SR_spcWeb_spcServiceStub) srv).setHeader("http://siebel.com/webservices", "SessionType", "Stateless");
        QuerySR_Input sr = new QuerySR_Input("RFS-1-339103333");
        QuerySR_Output srvo = srv.querySR(sr);
        out.println("Got from web service=" + srvo.getStatusCode() + srvo.getSource() + srvo.getAlternateServiceLocation() + srvo.getActualStartDate() + srvo.getAlternateContactName() + srvo.getAlternateEmailAddress());
        out.println("Got from web service=" + srvo.getAlternatePhone() + srvo.getArea() + srvo.getAssetAdditionalComments() + srvo.getAssetMake() + srvo.getAssetModel());
        out.println("Got from web service=" + srvo.getAssetNum() + srvo.getAssetType() + srvo.getBarcode() + srvo.getDescription() + srvo.getImpact() + srvo.getOnBehalfOfBadge());
        out.println("Got from web service=" + srvo.getOnBehalfOfIndex() + srvo.getOnBehalfOfMissionID() + srvo.getPointofContact());
    %>
</body>