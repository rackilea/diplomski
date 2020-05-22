interface ItemVisitor {
    void visitEmail(EmailItem item);
    void visitSms(SmsItem item);
}
interface Item {
    void accept(ItemVisitor v);
}
class EmailItem implements Item {
    public void accept(ItemVisitor v) { v.visitEmail(this); }
}
class SmsItem implements Item {
    public void accept(ItemVisitor v) { v.visitSms(this); }
}