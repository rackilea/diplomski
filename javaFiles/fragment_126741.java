// Fullscreen
requestWindowFeature(Window.FEATURE_NO_TITLE);
getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN);

setContentView(R.layout.welcomescreen);
wd = (ImageView) this.findViewById(R.id.lwd);