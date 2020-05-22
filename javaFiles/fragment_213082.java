public static boolean colorWillBeMasked(int color, Application app){
    if(android.R.color.transparent == color) return true;

    int[] rgb = {Color.red(color), Color.green(color), Color.blue(color)};

    int brightness =
        (int)Math.sqrt(
              rgb[0] * rgb[0] * .241 + 
              rgb[1] * rgb[1] * .691 + 
              rgb[2] * rgb[2] * .068);

    System.out.println("COLOR: " + color + ", BRIGHT: " + brightness);
    //note 0,black 1,classic 2
    int theme = app.api.getThemeView();

    // color is dark
    if(brightness <= 40){
        if(theme == 1) return true;
    }
    // color is light
    else if (brightness >= 215){
        if(theme == 2) return true;
    }
    return false;
}