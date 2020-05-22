public class I {

    private static I18n getI18n() {
        I18n getI18n = I18nFactory.getI18n(I.class, "i18n.Messages");
        Locale Locale = new Locale("fr");
        getI18n.setLocale(Locale);
        return getI18n;
    }

    public static String tr(String str) {
        return getI18n().tr(str);
    }

    public static String tr(String text, Object o1) {
        return getI18n().tr(text, o1);
    }

    public static String tr(String text, Object o1, Object o2) {
        return getI18n().tr(text, o1, o2);
    }

    public static String tr(String text, Object o1, Object o2, Object o3) {
        return getI18n().tr(text, o1, o2, o3);
    }

    public static String tr(String text, Object o1, Object o2, Object o3,
            Object o4) {
        return getI18n().tr(text, o1, o2, o3, o4);
    }

    public static String tr(String text, Object[] objects) {
        return getI18n().tr(text, objects);
    }

}