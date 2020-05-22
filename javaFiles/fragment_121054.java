public enum MessagePurpose {
    EVENT("event", EventBody.class);

    public final String purposeName;
    public final Class bodyClass;

    MessagePurpose(String purposeName, Class classi) {
        this.purposeName = purposeName;
        bodyClass = classi;
    }
}