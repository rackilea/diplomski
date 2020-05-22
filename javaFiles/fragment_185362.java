` final Handler handler = new Handler();
handler.postDelayed(new Runnable() {
    public void run() {
        int randomNum = random.nextInt(6);
        dice.setImageResource(images[randomNum]);
        handler.postDelayed(this, 500);
    }
}, 500);`