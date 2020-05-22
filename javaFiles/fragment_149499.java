private List<ShareField> findShareFields(Form form) {
    final List<ShareField> fields = Lists.newArrayList();
    form.visitChildren(ShareField.class, new IVisitor<ShareField>() {
        @Override
        public Object component(ShareField component) {
            fields.add(component);
            return CONTINUE_TRAVERSAL;
        }
    });
    return fields;
}