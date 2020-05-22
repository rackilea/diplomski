private String from;
private String to;
private String subject;

public Msg(String from, String to, String subject) {
    this.from = from;
    this.to = to;
    this.subject = subject;
}

public String getFrom() {
    return this.from;
}

public void setFrom(String from) {
    this.from = from;
}