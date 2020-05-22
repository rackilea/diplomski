@PrePersist
private void prePersist() {
    for (AttachmentModel am : attachments) {
        am.setNotice(this);
    }
}