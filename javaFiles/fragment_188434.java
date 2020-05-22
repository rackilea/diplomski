interface IFromBuilder {
    IToBuilder from(String from);
}

interface IToBuilder {
    IMailBuilder to(String to);
}

interface IMailBuilder {
    Mail build();
}

class MailBuilder implements IFromBuilder, IToBuilder, IMailBuilder {

    private String from;
    private String to;

    @Override
    public IToBuilder from(String from) {
        this.from = from;
        return this;
    }

    @Override
    public IMailBuilder to(String to) {
        this.to = to;
        return this;
    }

    @Override
    public Mail build() {
        return new Mail(from, to);
    }
}

class Mail {
    private final String from;
    private final String to;

    public Mail(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public static IFromBuilder newBuilder() {
        return new MailBuilder();
    }
}


public class Demo {
    public static void main(String[] args) {
        Mail mail = Mail.newBuilder().from("sender@a.com").to("receiver@b.com").build();
    }
}