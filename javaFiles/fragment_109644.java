class Example implements ItemVisitor {
    public void visitEmail(EmailItem item) {
        // Do something with an e-mail
    }
    public void visitSms(SmsItem item) {
        // Do something with an SMS
    }
    public static void main(String[] args) {
        Example e = new Example();
        for (Item item : ItemSource.getManyItems()) {
            item.accept(e);
        }
    }
}