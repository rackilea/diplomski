ValueMap props = ResourceUtil.getValueMap(resource);
    HtmlEmail email = new HtmlEmail();
    String[] mailTo = props.get("mailto", new String[0]);
    email.setFrom((String)props.get("from"));
        for (String toAddr : mailTo) {
            email.addTo(toAddr);
      }
    //========Email Attachments===============
    for (Map.Entry<String, RequestParameter[]> param : slingRequest.getRequestParameterMap().entrySet()) {
        RequestParameter rpm = param.getValue()[0];
        if(!rpm.isFormField()) {
            EmailAttachment attachment = new EmailAttachment();
            attachment.setPath(rpm.getFileName());
            attachment.setDisposition(EmailAttachment.ATTACHMENT);
            attachment.setDescription("Any Description");
            attachment.setName("Any name you can set");
            email.embed(new ByteArrayDataSource(rpm.get(), rpm.getContentType()), rpm.getFileName());
        }
    }
    //========Email Attachment END===========

    String emailTextToSend = "<p>Name: " + slingRequest.getParameter("name") + "</p>";
    emailTextToSend += "<p>Message: " + slingRequest.getParameter("message") + "</p>";
    email.setHtmlMsg(emailTextToSend);
    email.setSubject((String)props.get("subject"));
    MessageGatewayService messageGatewayService = sling.getService(MessageGatewayService.class);
    MessageGateway messageGateway = messageGatewayService.getGateway(HtmlEmail.class);
    messageGateway.send(email);