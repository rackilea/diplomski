public JavadocInfo applyTemplate(final IMember member, final JavadocInfo jdi) throws Exception {
    final JavadocInfo templateJdi = new JavadocInfo();
    final String text = JAutodocPlugin.getContext().getTemplateManager().applyTemplate(member,
            config.getProperties());
    if (text != null && text.length() > 0) {
        templateJdi.parseJavadoc(text);
    }
    return jdi.isEmpty() ? templateJdi : jdi.merge(templateJdi);
}