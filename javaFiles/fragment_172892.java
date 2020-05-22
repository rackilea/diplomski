@Override
    public void handleMessage(SoapMessage mc) throws Fault {
        super.handleMessage(mc);
        SOAPMessage soapMessage = mc.getContent(SOAPMessage.class);
        if (soapMessage != null) {
            if (soapMessage.countAttachments() > 0) {
                if (mc.getAttachments() == null) {
                    mc.setAttachments(new ArrayList<Attachment>(soapMessage
                            .countAttachments()));
                }
                Iterator<AttachmentPart> it = CastUtils.cast(soapMessage.getAttachments());
                while (it.hasNext()) {
                    AttachmentPart part = it.next();
                    String id = AttachmentUtil.cleanContentId(part.getContentId());
                    AttachmentImpl att = new AttachmentImpl(id);
                    try {
                        att.setDataHandler(part.getDataHandler());
                    } catch (SOAPException e) {
                        throw new Fault(e);
                    }
                    Iterator<MimeHeader> it2 = CastUtils.cast(part.getAllMimeHeaders());
                    while (it2.hasNext()) {
                        MimeHeader header = it2.next();
                        att.setHeader(header.getName(), header.getValue());
                    }
                    mc.getAttachments().add(att);
                    it.remove();
                }
            }
        }
    }