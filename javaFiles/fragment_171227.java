// Custom font file located in the "assets/fonts/"
 String customFont = "Helvetica-Neue.otf";
 CalligraphyConfig.initDefault(
     new CalligraphyConfig.Builder()
     .setDefaultFontPath("fonts/" + customFont)
     .build()
 );