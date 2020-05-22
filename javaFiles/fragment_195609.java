@Override
public String getMessageInternal(String code, Object[] objects, final Locale locale) {
        String foo = super.getMessageInternal(code, objects, locale);

        return foo == null ? code : foo;
    }
}