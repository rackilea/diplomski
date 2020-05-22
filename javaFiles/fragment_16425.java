public class DatabaseThemeSource implements ThemeSource {

    private YourThemeDao themeDao;

    public Theme getTheme( String themeName ) {

        if (themeName == null) { return null; }

        MessageSource messageSource = new DatabaseDrivenMessageSource( themeDao );

        theme = new SimpleTheme( themeName, messageSource );

        return theme;
    }

    // init your themeDao
}