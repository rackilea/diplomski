interface IFromBuilder {
    IToBuilder from(String from);
}

interface IToBuilder {
    ISubjectBuilder to(String to);
}

interface ISubjectBuilder {
    IBodyBuilder subject(String line);
}

interface IBodyBuilder {
    void body(String body);
}

class Mailer implements IFromBuilder, IToBuilder, ISubjectBuilder, IBodyBuilder {

    // implementations...
}