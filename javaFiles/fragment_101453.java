public class JPersianTextField2 extends JTextField {


    public JPersianTextField2() {
//        Hopefully someday (Oracle Love Iranians) and create This Locale for us
        Locale locale = new Locale("fa", "IR");
//        Locale locale = new Locale("ar", "KW");
        ComponentOrientation farsiOrientation = ComponentOrientation.getOrientation(locale);
        super.applyComponentOrientation(farsiOrientation);
        PlainDocument doc = (PlainDocument) super.getDocument();
        doc.setDocumentFilter(new PersianNumberDocumentFilter());
        super.setColumns(25);
    }

    @Override
    public String getText() {
        String tmp = super.getText();
        if (tmp != null && !tmp.isEmpty())
            return PersianNumber2.convertToStringWithEnglishNumber(tmp);
        else
            return super.getText();
    }

    @Override
    public void setText(String t) {
        if (t != null && !t.isEmpty())
            super.setText(PersianNumber2.convertToStringWithPersianNumber(t));
    }

}