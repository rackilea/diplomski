@Override
    public void handleMessage(SoapMessage msg) throws Fault {
        super.handleMessage(msg);
        SOAPMessage soapMessage = msg.getContent(SOAPMessage.class);
        soapMessage.removeAllAttachments();
        Collection<Attachment> atts = msg.getAttachments();
        if (atts != null) {
            for (Attachment a : atts) {
                if (a.getDataHandler().getDataSource() instanceof AttachmentDataSource) {
                    try {
                        ((AttachmentDataSource) a.getDataHandler().getDataSource()).cache(msg);
                    } catch (IOException e) {
                        throw new Fault(e);
                    }
                }
                AttachmentPart ap = soapMessage.createAttachmentPart(a.getDataHandler());
                Iterator<String> i = a.getHeaderNames();
                while (i != null && i.hasNext()) {
                    String h = i.next();
                    String val = a.getHeader(h);
                    ap.addMimeHeader(h, val);
                }
                if (StringUtils.isEmpty(ap.getContentId())) {
                    ap.setContentId(a.getId());
                }
                soapMessage.addAttachmentPart(ap);
            }
        }
        msg.setAttachments(Collections.<Attachment>emptyList());
        msg.setContent(SOAPMessage.class, soapMessage);
    }