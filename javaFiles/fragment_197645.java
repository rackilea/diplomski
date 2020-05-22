for (NoticesModel notice : notices) {
    for (AttachmentModel am : notice.getAttachments()) {
        am.setNotice(notice);
    }
    noticesServices.save(notice);
}