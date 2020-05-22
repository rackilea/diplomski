public int getSourceActions(JComponent c) {
PropertyDescriptor prop = getPropertyDescriptor(c);
if (prop != null) {
    return COPY;
}
return NONE;
}