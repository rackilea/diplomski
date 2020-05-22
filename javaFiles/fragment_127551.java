AttachmentInterceptor ai = new AttachmentInterceptor();
    wst.setInterceptors(new ClientInterceptor [] { ai });
    wst.sendSourceAndReceiveToResult(src, result);

    /**
     * get attachment
     */
    Iterator<Attachment> it = ai.getAttachments();