public void flashButton(int color) {
    final ImageView colors = findViewById(R.id.buttonsImage);
    final int newColor = color;
    if(newColor == 1)
        colors.setImageResource(R.drawable.green_activated_png);
    if(newColor == 2)
        colors.setImageResource(R.drawable.yellow_activated_png);
    if(newColor == 3)
        colors.setImageResource(R.drawable.red_activated_png);
    if(newColor == 4)
        colors.setImageResource(R.drawable.blue_activated_png);
    System.out.println("Flashed color: " + newColor);

    Handler handler = new Handler();
    final Runnable r = new Runnable() {
        public void run() {
            colors.setImageResource(R.drawable.normal_buttons);
            System.out.println("Returned Color.");
        }
    };
    handler.postDelayed(r, 1000);
}