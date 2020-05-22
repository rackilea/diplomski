private static final StackWalker STACK_WALKER
    = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);

public static String translate(Locale locale, String s) {
    for(ResourceBundle bundle: getResourceBundles(locale,
                                   STACK_WALKER.getCallerClass().getClassLoader())) {
        try {
            return bundle.getString(s);
        }catch (MissingResourceException e) {
            //ignore/next iteration
        }
    }
    return s;
}