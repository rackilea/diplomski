public static void show(View v
                       , CharSequence snapbarString
                       , CharSequence snapbarTitle) {
    toaster.show(v, snapbarString, snapbarTitle);
}

private static final Toaster toaster = classPresent("${package}.Snackbar") 
                                     ? snackbar() 
                                     : locally();

private static Toaster locally() {
    return (view, message, title) -> Toast.makeText(view.getContext()
                                                   , message
                                                   , Toast.LENGTH_LONG).show(); 
}

private static Toaster snackbar() {
    View.OnClickListener NOTHING = (view)->{};
    return (view, message, title) -> {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG)
                .setAction(title, NOTHING).show();
    };
}

interface Toaster {
    void show(View view, CharSequence message, CharSequence title);
}

private static boolean classPresent(String className) {
    try {
        ClassLoader.getSystemClassLoader().loadClass(className);
        return true;
    } catch (ClassNotFoundException ex) {
        return false;
    }
}