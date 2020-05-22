class EnumToIconConverter extends AbstractConverter {

    EnumToIconConverter(ValueModel subject) {
        super(subject);
    }

    @Override
    public Object convertFromSubject(Object enum) {
        return enum == Selection.selection1 ? image1 : image2;
    }

    @Override
    public void setValue(Object obj) {
        throw new UnsupportedOperationException("setValue makes no sense for this converter");
    }
}