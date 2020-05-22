private static final boolean isSnackbarPresent; 

static{                                                             
      isSnackbarPresent = classPresent("${package}.Snackbar");
}

private static boolean classPresent(String className) {
    try {
        ClassLoader.getSystemClassLoader().loadClass(className);
        return true;
    } catch (ClassNotFoundException ex) {
        return false;
    }
}

public static void show(View v
                       , CharSequence snapbarString
                       , CharSequence snapbarTitle) {

  if(isSnackbarPresent){
    Snackbar.make(v, snapbarString, Snackbar.LENGTH_LONG)
            .setAction(snapbarTitle, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // no implementation required
                }
            }).show();
  }else{
    Toast.makeText(v.getContext(), snapbarString, Toast.LENGTH_LONG).show();
  }
}