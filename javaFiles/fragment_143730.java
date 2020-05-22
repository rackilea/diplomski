public class EmailFormatter implements Formatter<Email> {

    @Override
    public String print(Email email, Locale locale) {
        return email.getValue();
    }

    @Override
    public Email parse(String mailAddress, Locale locale) throws ParseException {
        return new Email(mailAddress);
    }

}