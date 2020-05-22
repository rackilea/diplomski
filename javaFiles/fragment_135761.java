public static void main(String[] args) {
    I18n i18n = I18nFactory.getI18n(I18nExample.class, "Messages");
    for (int i = 0; i < 2; i++) {
        if (i == 0) {
            print("First run");
        } else {
            print("Second run");
            i18n.setLocale(Locale.GERMAN);
        }

        print("Current locale: " + i18n.getLocale());

        print(i18n.tr("This text is marked for translation and is translated"));

        String mark = i18n.marktr("This text is marked for translation but not translated");
        print(mark);
        print(i18n.tr(mark));

        mark = i18n.tr("This is the {0}. text to be translated", "chat (noun)");
        print(mark);

        mark = i18n.tr("This is the {0}. text to be translated", "chat (verb)");
        print(mark);

        print(i18n.tr("chat (noun)"));
        print(i18n.tr("chat (verb)"));

        print("");
    }
}